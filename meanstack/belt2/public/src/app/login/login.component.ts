import { Component, OnInit } from '@angular/core';
import { User } from './../user';
import { Bucket } from './../bucket';
import { UserService } from './../user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user: User = new User();
  users: Array<User>;
  switch: boolean = true;
  constructor(private _usersServices: UserService, private _router: Router ) { }


  ngOnInit() {
  }

  onSubmit(id) {
    this._usersServices.addUser(this.user);
    console.log(this.user);
    this.user = new User();
    console.log('user went to save!!!');
    this._router.navigate([`/dashboard/${this.user._id}`]);
  }
}
