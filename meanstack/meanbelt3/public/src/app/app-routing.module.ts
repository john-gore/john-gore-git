import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { NewAnswerComponent } from './new-answer/new-answer.component';
import { NewQuestionComponent } from './new-question/new-question.component';
import { LoginComponent } from './login/login.component';
import { AnswerComponent } from './answer/answer.component';
import { LogoutComponent } from './logout/logout.component';

const routes: Routes = [
  {
    path: 'dashboard',
    // pathMatch: 'full',
    component: DashboardComponent,
    children: [],
  },
  {
    path: 'newanswer/:id',
    pathMatch: 'full',
    component: NewAnswerComponent,
    children: [],
  },
  {
    path: 'newquestion',
    pathMatch: 'full',
    component: NewQuestionComponent,
    children: [],
  },
  {
    path: 'answer/:id',
    pathMatch: 'full',
    component: AnswerComponent,
    children: [],
  },
  {
    path: '',
    // pathMatch: 'full',
    component: LoginComponent,
    children: [],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
