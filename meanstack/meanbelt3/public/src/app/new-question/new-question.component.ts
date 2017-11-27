import { Component, OnInit } from '@angular/core';
import { User } from './../user';
import { Question } from './../question';
import { UserService } from './../user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-new-question',
  templateUrl: './new-question.component.html',
  styleUrls: ['./new-question.component.css']
})
export class NewQuestionComponent implements OnInit {
  question: Question = new Question();
  questions: Array<Question>;
  switch: boolean = true;

  constructor(private _usersServices: UserService, private _router: Router ) { }

  ngOnInit() {
  }

  onSubmit() {
    console.log(this.question);
    console.log('question went to save!!!');
    this._usersServices.addQuestion(this.question);
    this.question = new Question();
    this._router.navigate(['/dashboard']);
  }

  cancel () {
    this._router.navigate(['/dashboard']);
  }
  logout() {
    console.log('in logout');
    this._usersServices.logout();
  }
  home() {
    this._router.navigate(['/dashboard']);
  }
}
