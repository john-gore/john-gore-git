const mongoose = require('mongoose');

const NoteSchema = new mongoose.Schema({
    note: String,
}, {timestamps: true});

mongoose.model('Note', NoteSchema)