import { Component, OnInit } from '@angular/core';
import { User } from './../user';
import { Question } from './../question';
import { UserService } from './../user.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-play',
  templateUrl: './play.component.html',
  styleUrls: ['./play.component.css']
})
export class PlayComponent implements OnInit {
  questions: Question[];
  user: User = new User();
  users: Array<User>;


  constructor(private _questionsServices: UserService, private _usersServices: UserService,  private _router: Router) {
    this._questionsServices.questionsObservable.subscribe(
      (questions) => {
        this.questions = questions;
      }
    );
  }

  ngOnInit() {
    this._questionsServices.getQuestions();
  }

  onSubmit() {
    this._usersServices.updateUser(this.user);
    console.log(this.user);
    console.log('user score updated went to save!!!');
    this._router.navigate(['/dashboard']);
  }
}
