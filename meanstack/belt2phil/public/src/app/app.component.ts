import { Component } from '@angular/core';
import { BucketListService } from './bucket-list.service';
import { User } from './user';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Trivia Game';
  user: User;
}
