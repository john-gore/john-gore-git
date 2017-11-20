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
  users: User[];


  constructor(private _usersServices: UserService, private _router: Router) {
    this._usersServices.usersObservable.subscribe(
      (users) => {
        this.users = users;
      }
    );
   }

  ngOnInit() {
    this._usersServices.getUsers();
  }
  addnew() {
    this._router.navigate(['/newquestion']);
  }
  play() {
    this._router.navigate(['/play']);
  }
  logout() {
    this._router.navigate(['']);
  }
  home() {
    this._router.navigate(['/dashboard']);
  }
}
