import { Component, OnInit } from '@angular/core';
import { User } from './../user';
import { Bucket } from './../bucket';
import { UserService } from './../user.service';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  users: User[];
  // buckets: Bucket[];
  bucket: Bucket = new Bucket();
  buckets: Array<Bucket>;
  switch: boolean = true;
  dog: string;
  add = {
    addedname: '',
  };

  form = [];


  constructor(private _route: ActivatedRoute, private _usersServices: UserService, private _router: Router) {
    this._usersServices.usersObservable.subscribe(
      (users) => {
        this.users = users;
      }
    );

    this._usersServices.bucketsObservable.subscribe(
      (buckets) => {
        this.buckets = buckets;
      }
    );
    this._route.paramMap.subscribe( params => {
      console.log(3);
      console.log(params.get('id'));
      this.dog = params.get('id');
      console.log(this.dog);
        });
          }

  ngOnInit() {
    this._usersServices.getUsers();
    this._usersServices.getBucket(id);
  }

  onSubmit() {
    this._usersServices.addBucket(this.bucket);
    console.log(this.bucket);
    this.bucket = new Bucket ();
    console.log('bucket went to save!!!');
    this.form.push(this.add);
  }

  show(id) {
    this._usersServices.getUser(id);
    this._router.navigate([`/profile/${id}`]);
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
