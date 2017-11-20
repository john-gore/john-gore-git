import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddPlayerComponent } from './add-player/add-player.component';
import { HomeComponent } from './home/home.component';
import { PlayerStatusComponent } from './player-status/player-status.component';
const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
    children: [],
  },
  {
    path: 'addplayer',
    component: AddPlayerComponent,
    children: [],
  },
  {
    path: 'playerstatus',
    component: PlayerStatusComponent,
    children: [],
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
