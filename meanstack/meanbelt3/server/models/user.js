const mongoose = require('mongoose');
var Schema = mongoose.Schema;

const UserSchema = new mongoose.Schema({
    name: String,
    questions: [{type: Schema.Types.ObjectId, ref: 'Question'}]
}, {timestamps: true});

mongoose.model('User', UserSchema)