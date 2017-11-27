import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'; // <-- Import FormsModule
import { HttpModule } from '@angular/http'; // <-- Import HttpModule
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BikeOfDayComponent } from './bike-of-day/bike-of-day.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { BikeListComponent } from './dashboard/bike-list/bike-list.component';
import { BikeCreateComponent } from './dashboard/bike-create/bike-create.component';
import { DeleteComponent } from './dashboard/bike-edit/delete/delete.component';
import { UserService } from './user.service';
import { BikeService } from './bike.service';



@NgModule({
  declarations: [
    AppComponent,
    BikeOfDayComponent,
    LoginComponent,
    RegisterComponent,
    DashboardComponent,
    BikeListComponent,
    BikeCreateComponent,
    DeleteComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpModule,
  ],
  providers: [UserService, BikeService],
  bootstrap: [AppComponent]
})
export class AppModule { }
