import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { Bucket } from './../bucket';
import { User } from './../user';
import { UserService } from './../user.service';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class ProfileComponent implements OnInit {
  bucket: Bucket[];
  user: User [];
  dog: string;

  constructor(private _route: ActivatedRoute, private _bucketsService: UserService, private _router: Router) {
    this._bucketsService.bucketsObservable.subscribe(
      (buckets) => {
        this.bucket = buckets;
      }
    ),
    this._bucketsService.usersObservable.subscribe(
      (users) => {
        this.user = users;
      }
    ),

    this._route.paramMap.subscribe( params => {
      console.log(3);
      console.log(params.get('id'));
      this.dog = params.get('id');
      console.log(this.dog);
        });
          }

  ngOnInit (dog) {
    this._bucketsService.getUser(this.dog);
    this._bucketsService.usersObservable.subscribe(
      (users) => {
        this.user = users;
        console.log(this.user);
      });
  }

}
