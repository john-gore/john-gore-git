import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { PlayerStatusComponent } from './player-status/player-status.component';
import { AddPlayerComponent } from './add-player/add-player.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    PlayerStatusComponent,
    AddPlayerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
