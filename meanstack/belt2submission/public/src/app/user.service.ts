import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Bucket } from './bucket';
import { User } from './user';
import { BehaviorSubject } from 'rxjs';

@Injectable()
export class UserService {
  buckets: Bucket[];
  bucketsObservable = new BehaviorSubject(this.buckets);
  users: User[];
  usersObservable = new BehaviorSubject(this.users);
  user = {
    name: "",
  }
  form=[];


  constructor(private _http: Http) { }

  getUsers() {
    // send a request to the express server
    this._http.get('/users').subscribe(
      (users) => {
        // succesful call
        this.users = users.json();
        this.usersObservable.next(this.users);
      },
      (error) => {
        // unsuccessfull call
        console.log(error);
      }
    );
  }

  getBuckets() {
    // send a request to the express server
    this._http.get('/buckets').subscribe(
      (buckets) => {
        // succesful call
        this.buckets = buckets.json();
        this.bucketsObservable.next(this.buckets);
      },
      (error) => {
        // unsuccessfull call
        console.log(error);
      }
    );
    // update the notes array
    // add to the noteObservable
  }
  addUser(user: User) {
    console.log('user to create!!!' , user);
    this._http.post('/users', user).subscribe(
      (userCreated) => {
        this.usersObservable.next(this.users);
      }
    );
  }
  addBucket(bucket: Bucket) {
    console.log('buckets to create' , bucket);
    this._http.post('/buckets/create', bucket).subscribe(
      (bucketCreated) => {
        this.bucketsObservable.next(this.buckets);
      }, (error) => {
        console.log(error);
      }
    );
  }
  updateUser(user: User) {
    console.log('User Updated function hit!!!');
    this._http.post('/users/update/:id', user).subscribe(
      (userUpdated) => {
        this.users.push(userUpdated.json());
        this.usersObservable.next(this.users);
      }, (error) => {
        console.log(error);
      }
    );
  }
  getBucket(id: string) {
    console.log('2');
    this._http.get(`/user/${id}`).subscribe(
      (buckets) => {
        // if call = success
        this.buckets = buckets.json();
        console.log(this.buckets);
        this.bucketsObservable.next(this.buckets);
      },
      (error) => {
        // if call != success
        console.log(error);
      }
    );
  }
  getUser(id: string) {
    console.log('hit the get user function!!!');
    this._http.get(`/users/${id}`).subscribe(
      (users) => {
        // if call = success
        this.users = users.json();
        console.log(this.users);
        this.usersObservable.next(this.users);
      },
      (error) => {
        // if call != success
        console.log(error);
      }
    );
  }
}
