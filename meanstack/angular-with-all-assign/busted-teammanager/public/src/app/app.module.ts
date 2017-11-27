import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'; // <-- Import FormsModule
import { HttpModule } from '@angular/http'; // <-- Import HttpModule
import { AppRoutingModule } from './app-routing.module';
import { PlayersService } from './players.service';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { AddPlayerComponent } from './add-player/add-player.component';
import { PlayerStatusComponent } from './player-status/player-status.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AddPlayerComponent,
    PlayerStatusComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
		HttpModule
  ],
  providers: [PlayersService],
  bootstrap: [AppComponent]
})
export class AppModule { }
