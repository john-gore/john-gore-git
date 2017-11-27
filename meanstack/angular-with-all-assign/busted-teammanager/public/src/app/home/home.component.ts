import { Component, OnInit } from '@angular/core';
import { PlayersService } from './../players.service';
import { Player } from './../players';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  players: Player[];

  constructor(private _playersServices) {
    this._playersServices.playersObservable.subscribe(
      (players) => {
        this.players = players;
      }
    );
   }

  ngOnInit() {
    
  }

}
