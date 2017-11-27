import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Answer } from './answer';
import { Question } from './question';
import { User } from './user';
import { BehaviorSubject } from 'rxjs';
import { Router } from '@angular/router';

@Injectable()
export class UserService {
  user: User;
  users: User[];
  usersObservable = new BehaviorSubject(this.users);
  question: Question;
  questions: Question[];
  questionsObservable = new BehaviorSubject(this.questions);
  answer: Answer;
  answers: Answer[];
  answersObservable = new BehaviorSubject(this.answers);


  constructor(private _http: Http, private _router: Router) { }


  loginUser(user: User) {
    this._http.post('/users', user).subscribe(
      (success) => {
        // redirect to dashboard
        console.log('user create response:', success.json());
        this.user = user;
        this._router.navigate(['dashboard']);
      },
      (error) => {
        // redirect to index
        console.log('errors in login are: ', error);
        this._router.navigate(['']);
      }
    );
  }
  getUsers(callback) {
    // send a request to the express server
    this._http.get('/users').subscribe(
      (users) => {
        // succesful call
        this.users = users.json();
      },
      (error) => {
        // unsuccessfull call
        console.log(error);
      }
    );
  }

  getQuestions() {
    // send a request to the express server
    this._http.get('/questions').subscribe(
      (questions) => {
        // succesful call
        this.questions = questions.json();
        this.questionsObservable.next(this.questions);
      },
      (error) => {
        // unsuccessfull call
        console.log(error);
      }
    );
    // update the notes array
    // add to the noteObservable
  }

  addQuestion(question: Question) {
    console.log('questions to create' , question);
    this._http.post('/questions/create', question).subscribe(
      (questionCreated) => {
        this.questionsObservable.next(this.questions);
      }, (error) => {
        console.log(error);
      }
    );
  }
  updateUser(user: User) {
    console.log('User Updated function hit!!!');
    this._http.post('/users/update/:id', user).subscribe(
      (userUpdated) => {
        this.users.push(userUpdated.json());
        this.usersObservable.next(this.users);
      }, (error) => {
        console.log(error);
      }
    );
  }
  logout() {
    this._http.get('/logout').subscribe(
      (success) => {
        console.log(success);
        this.user = undefined;
        this._router.navigate(['']);
      },
      (error) => {
        console.log('errors');
      }
    );
  }
  getQuestion(id: string) {
    console.log('2');
    this._http.get(`/questions/${id}`).subscribe(
      (questions) => {
        // if call = success
        this.questions = questions.json();
        console.log(3);
        console.log(questions.json());
        console.log(4);
        this.questionsObservable.next(this.questions);
      },
      (error) => {
        // if call != success
        console.log(error);
      }
    );
  }
  addanswer(answer: Answer, id: string) {
    console.log('answer to create');
    console.log(answer);
    console.log('here is the id');
    console.log(id);
    this._http.post(`/answers/create/${id}`, answer).subscribe(
      (answerCreated) => {
        console.log('answer saved in backend!');
        this.answersObservable.next(this.answers);
      }, (error) => {
        console.log(error);
      }
    );
  }
  getAnswers(id) {
    console.log('going to get answers');
    this._http.get(`/answers/${id}`).subscribe(
      (answers) => {
        // succesful call
        this.answers = answers.json();
        this.answersObservable.next(this.answers);
      },
      (error) => {
        // unsuccessfull call
        console.log(error);
      }
    );
  }
  like(id, answer) {
    console.log('liking the answer!');
    this._http.post(`/answers/like/${id}`, answer).subscribe(
      (answers) => {
        // succesful call
        this.answers = answers.json();
        this.answersObservable.next(this.answers);
      },
      (error) => {
        // unsuccessfull call
        console.log(error);
      }
    );
  }
}
