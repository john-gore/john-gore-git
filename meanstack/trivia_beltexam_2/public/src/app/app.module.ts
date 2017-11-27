import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { PlayComponent } from './play/play.component';
import { NewQuestionComponent } from './new-question/new-question.component';
import { UserService } from './user.service';
import { FormsModule } from '@angular/forms'; // <-- Import FormsModule
import { HttpModule } from '@angular/http';
import { LoginComponent } from './login/login.component'; // <-- Import HttpModule


@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    PlayComponent,
    NewQuestionComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpModule,
  ],
  providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
