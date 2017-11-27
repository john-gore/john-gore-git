import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { NewQuestionComponent } from './new-question/new-question.component';
import { UserService } from './user.service';
import { FormsModule } from '@angular/forms'; // <-- Import FormsModule
import { HttpModule } from '@angular/http';
import { LoginComponent } from './login/login.component';
import { NewAnswerComponent } from './new-answer/new-answer.component';
import { AnswerComponent } from './answer/answer.component';
import { LogoutComponent } from './logout/logout.component';
import { AnswerListComponent } from './answer-list/answer-list.component'; // <-- Import HttpModule


@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    NewQuestionComponent,
    LoginComponent,
    NewAnswerComponent,
    AnswerComponent,
    LogoutComponent,
    AnswerListComponent
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
