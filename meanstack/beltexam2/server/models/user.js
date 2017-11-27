const mongoose = require('mongoose');
const Schema = mongoose.Schema;

const NoteSchema = new mongoose.Schema({
    name: String,
    lists: [{type: Schema.Types.ObjectId, ref: 'Bucket'}]
}, {timestamps: true});

mongoose.model('User', NoteSchema)