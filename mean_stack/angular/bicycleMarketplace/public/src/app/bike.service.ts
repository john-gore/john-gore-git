import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Bike } from './bike';
import { User } from './user';
import { BehaviorSubject } from 'rxjs';

@Injectable()
export class BikeService {
  bikes: Bike[];
  bikesObservable = new BehaviorSubject(this.bikes);
  users: User[];
  usersObservable = new BehaviorSubject(this.users);

  constructor(private _http: Http) { }

  getBikes() {
    // send a request to the express server
    this._http.get('/bikes').subscribe(
      (bikes) => {
        // succesful call
        this.bikes = bikes.json();
        this.bikesObservable.next(this.bikes);
      },
      (error) => {
        // unsuccessfull call
        console.log(error);
      }
    );
    // update the notes array
    // add to the noteObservable
  }
  addBike(bike: Bike) {
    console.log('bike to create' , bike);
    this._http.post('/bikes/create', bike).subscribe(
      (bikeCreated) => {
        this.bikes.push(bikeCreated.json());
        this.bikesObservable.next(this.bikes);
      }, (error) => {
        console.log(error);
      }
    );
  }
  updateBike(bike: Bike) {
    console.log('Bike Updated function hit!!!');
    this._http.post('/bikes/update/:id', bike).subscribe(
      (bikeUpdated) => {
        this.bikes.push(bikeUpdated.json());
        this.bikesObservable.next(this.bikes);
      }, (error) => {
        console.log(error);
      }
    );
  }
  deleteBike(bike: Bike) {
    console.log('bike deleted function hit!!!');
    this._http.post('/bikes/delete/:id', bike).subscribe(
      (bikeDeleted) => {
        console.log('successfully deleted!');
        this.bikes = bikeDeleted.json();
      }, (error) => {
        console.log(error);
      }
    );
  }
  addUser(user: User) {
    console.log('bike to create!!!' , user);
    this._http.post('/users/create', user).subscribe(
      (userCreated) => {
        this.users.push(userCreated.json());
        this.usersObservable.next(this.users);
      }
    );
  }
}
