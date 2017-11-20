import { Component, OnInit } from '@angular/core';
import { User } from './../../user';
import { Bike } from './../../bike';
import { BikeService } from './../../bike.service';

@Component({
  selector: 'app-bike-list',
  templateUrl: './bike-list.component.html',
  styleUrls: ['./bike-list.component.css']
})
export class BikeListComponent implements OnInit {
  bikes: Bike [];

  constructor(private _bikesServices: BikeService) {
    this._bikesServices.bikesObservable.subscribe(
      (bikes) => {
        this.bikes = bikes;
      }
    );
   }

  ngOnInit() {
    this._bikesServices.getBikes();
  }

}
