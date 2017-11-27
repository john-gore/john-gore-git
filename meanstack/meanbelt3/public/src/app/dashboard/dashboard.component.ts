import { Component, OnInit } from '@angular/core';
import { User } from './../user';
import { Question } from './../question';
import { UserService } from './../user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  user: User;
  users: User[];
  question: Question = new Question();
  questions: Array<Question>;


  constructor(private _usersServices: UserService, private _router: Router) { }

  ngOnInit() {
    this.user = this._usersServices.user;
    this._usersServices.getUsers((users) => {
      this.users = users;
    });
    this._usersServices.getQuestions();
    this._usersServices.questionsObservable.subscribe((questions) => {
      this.questions = questions;
    });
  }
  addnew() {
    this._router.navigate(['/newquestion']);
  }
  logout() {
    console.log('in logout');
    this._usersServices.logout();
  }
  home() {
    this._router.navigate(['/dashboard']);
  }
  questiondetails(id) {
    this._router.navigate([`/answer/${id}`]);
  }
  answer(id) {
    this._router.navigate([`/newanswer/${id}`]);
  }
}
