import { Component, OnInit } from '@angular/core';
import { Note } from './../note';
import { NotesService } from './../notes.service';

@Component({
  selector: 'app-notes-create',
  templateUrl: './notes-create.component.html',
  styleUrls: ['./notes-create.component.css']
})
export class NotesCreateComponent implements OnInit {
  note: Note = new Note();


  constructor(private _notesServices: NotesService) { }

  ngOnInit() {
  }

  onSubmit() {
    this._notesServices.addNote(this.note);
    this.note = new Note();
  }
}
