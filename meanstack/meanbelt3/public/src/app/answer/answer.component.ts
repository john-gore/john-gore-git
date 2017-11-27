import { Component, OnInit, Input } from '@angular/core';
import { Injectable } from '@angular/core';
import { User } from './../user';
import { Question } from './../question';
import { UserService } from './../user.service';
import { Router } from '@angular/router';
import { Answer } from './../answer';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-answer',
  templateUrl: './answer.component.html',
  styleUrls: ['./answer.component.css']
})
export class AnswerComponent implements OnInit {


  constructor(private _route: ActivatedRoute, private _usersServices: UserService, private _router: Router) { }
  question: Question = new Question();
  questions: Array<Question>;
  answer: Answer = new Answer();
  answers: Array<Answer>;
  dog: string;


  ngOnInit() {
    this._route.paramMap.subscribe( params => {
      console.log(params.get('id'));
      this.dog = params.get('id');
      console.log(this.dog);
    });

    this._usersServices.getQuestion(this.dog);
    this._usersServices.questionsObservable.subscribe((questions) => {
      this.questions = questions;
    });

    this._usersServices.getAnswers(this.dog);
    this._usersServices.answersObservable.subscribe((answers) => {
      this.answers = answers;
    });
  }
  logout() {
    console.log('in logout');
    this._usersServices.logout();
  }
  like(id, answer) {
    console.log(id);
    this._usersServices.like(id, this.answer);
  }
  home() {
    this._router.navigate(['/dashboard']);
  }
}
