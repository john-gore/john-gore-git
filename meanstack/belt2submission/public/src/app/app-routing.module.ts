import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ProfileComponent } from './profile/profile.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  {
    path: 'dashboard/:id',
    // pathMatch: 'full',
    component: DashboardComponent,
    children: [],
  },
  {
    path: 'profile/:id',
    pathMatch: 'full',
    component: ProfileComponent,
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
