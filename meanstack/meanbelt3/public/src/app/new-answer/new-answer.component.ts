import { Component, OnInit } from '@angular/core';
import { Injectable } from '@angular/core';
import { User } from './../user';
import { Question } from './../question';
import { UserService } from './../user.service';
import { Router } from '@angular/router';
import { Answer } from './../answer';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-new-answer',
  templateUrl: './new-answer.component.html',
  styleUrls: ['./new-answer.component.css']
})
export class NewAnswerComponent implements OnInit {
  answer: Answer = new Answer();
  answers: Array<Answer>;
  dog: string;

  constructor(private _route: ActivatedRoute, private _usersServices: UserService, private _router: Router) { }

  ngOnInit() {
    this._route.paramMap.subscribe( params => {
      console.log(params.get('id'));
      this.dog = params.get('id');
      console.log(this.dog);
    });
  }
  home() {
    this._router.navigate(['/dashboard']);
  }
  onSubmit() {
    console.log('submit worked');
    console.log(this.answer);
    console.log(this.dog);
    this._usersServices.addanswer(this.answer, this.dog);
    this.answer = new Answer();
    console.log('answer went to save in newanswer comp!!!');
  }
  question() {

  }
  logout() {
    console.log('in logout');
    this._usersServices.logout();
  }
}
