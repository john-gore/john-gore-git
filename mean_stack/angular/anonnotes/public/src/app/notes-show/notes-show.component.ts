import { Component, OnInit } from '@angular/core';
import { NotesService } from './../notes.service';
import { Http } from '@angular/http';
import { Note } from './../note';

@Component({
  selector: 'app-notes-show',
  templateUrl: './notes-show.component.html',
  styleUrls: ['./notes-show.component.css']
})
export class NotesShowComponent implements OnInit {
  notes: Note [];

  constructor(private _notesServices: NotesService) {
    this._notesServices.notesObservable.subscribe(
      (notes) => {
        this.notes = notes;
      });
  }

  ngOnInit() {
    this._notesServices.getNotes();
  }

}
