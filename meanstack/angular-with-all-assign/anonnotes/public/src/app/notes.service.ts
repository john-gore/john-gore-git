import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Note } from './note';
import { BehaviorSubject } from 'rxjs';

@Injectable()
export class NotesService {
  notes: Note[];
  notesObservable = new BehaviorSubject(this.notes);


  constructor(private _http: Http) { }

  getNotes() {
    // send a request to the express server
    this._http.get('/notes').subscribe(
      (notes) => {
        // succesful call
        this.notes = notes.json();
        this.notesObservable.next(this.notes);
      },
      (error) => {
        // unsuccessfull call
        console.log(error);
      }
    );
    // update the notes array
    // add to the noteObservable
  }
  addNote(note: Note) {
    console.log('note to create' , note);
    this._http.post('/notes', note).subscribe(
      (noteCreated) =>{
        this.notes.push(noteCreated.json());
        this.notesObservable.next(this.notes);
      }
    );
  }
}
