import { Component, OnInit } from '@angular/core';
import { User } from './../user';
import { BikeService } from './../bike.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  user: User = new User();


  constructor(private _usersServices: BikeService) { }

  ngOnInit() {
  }

  onSubmit() {
    this._usersServices.addUser(this.user);
    this.user = new User();
  }

}
