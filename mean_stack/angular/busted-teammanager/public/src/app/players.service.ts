import { Injectable } from '@angular/core';
import { Http } from '@angular/Http';
import { Player } from './players';
import { BehaviorSubject } from 'rxjs'


@Injectable()
export class PlayersService {
  players: Player[];
  playersObservable = new BehaviorSubject(this.players);


  constructor(private _http: Http) { }

    getPlayers() {
      this._http.get('/players').subscribe(
        (players) => {
          // successful call
          this.players = players.json();
          this.playersObservable.next(this.players);
        },
         (errors) => {
          console.log(errors);
        }
      );
    }
}
