import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { BikeOfDayComponent } from './bike-of-day/bike-of-day.component';
import { RegisterComponent } from './register/register.component';
import { BikeListComponent } from './dashboard/bike-list/bike-list.component';
import { DeleteComponent } from './dashboard/bike-edit/delete/delete.component';
import { BikeCreateComponent } from './dashboard/bike-create/bike-create.component';
// import { BikeEditComponent } from './dashboard/bike-edit/bike-edit.component';



const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    component: LoginComponent,
    children: [],
  },
  {
    path: 'dashboard', redirectTo: '/dashboard/bike-list', pathMatch: 'full'
  },
  {
    path: 'dashboard',
    // pathMatch: 'full',
    component: DashboardComponent,
    children: [
      {
        path: 'bike-list',
        pathMatch: 'full',
        component: BikeListComponent,
        children: [],
      },
      {
        path: 'bike-edit',
        pathMatch: 'full',
        component: DeleteComponent,
        children: [],
      },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
