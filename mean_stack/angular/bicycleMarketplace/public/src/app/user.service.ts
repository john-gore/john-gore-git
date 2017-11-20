import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { User } from './user';
import { BehaviorSubject } from 'rxjs';

@Injectable()
export class UserService {
  users: User[];
  usersObservable = new BehaviorSubject(this.users);

  constructor(private _http: Http) { }


}