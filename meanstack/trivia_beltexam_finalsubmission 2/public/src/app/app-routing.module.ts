import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { PlayComponent } from './play/play.component';
import { NewQuestionComponent } from './new-question/new-question.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  {
    path: 'dashboard',
    // pathMatch: 'full',
    component: DashboardComponent,
    children: [],
  },
  {
    path: 'play',
    pathMatch: 'full',
    component: PlayComponent,
    children: [],
  },
  {
    path: 'newquestion',
    pathMatch: 'full',
    component: NewQuestionComponent,
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
