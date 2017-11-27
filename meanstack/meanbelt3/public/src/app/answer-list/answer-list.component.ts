import { Component, OnInit,  Input} from '@angular/core';
import { User } from './../user';
import { Question } from './../question';
import { UserService } from './../user.service';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { Answer } from './../answer';

@Component({
  selector: 'app-answer-list',
  templateUrl: './answer-list.component.html',
  styleUrls: ['./answer-list.component.css']
})
export class AnswerListComponent implements OnInit {
  answer = new Answer();
  answers: any;
  dog: string;

  constructor(private _route: ActivatedRoute, private _usersServices: UserService, private _router: Router) { }

  ngOnInit() {
    this._route.paramMap.subscribe( params => {
      console.log(params.get('id'));
      this.dog = params.get('id');
      console.log(this.dog);
    });
  }
}
