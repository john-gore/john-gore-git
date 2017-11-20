import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Question } from './question';
import { User } from './user';
import { BehaviorSubject } from 'rxjs';

@Injectable()
export class UserService {
  questions: Question[];
  questionsObservable = new BehaviorSubject(this.questions);
  users: User[];
  usersObservable = new BehaviorSubject(this.users);



  constructor(private _http: Http) { }

  getUsers() {
    // send a request to the express server
    this._http.get('/users').subscribe(
      (users) => {
        // succesful call
        this.users = users.json();
        this.usersObservable.next(this.users);
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
  addUser(user: User) {
    console.log('user to create!!!' , user);
    this._http.post('/users', user).subscribe(
      (userCreated) => {
        this.usersObservable.next(this.users);
      }
    );
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
}
