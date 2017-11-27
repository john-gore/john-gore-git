const mongoose = require('mongoose');
var Schema = mongoose.Schema;

const UserSchema = new mongoose.Schema({
    name: String,
    score: Number,
    percentage: Number,
    questions: [{type: Schema.Types.ObjectId, ref: 'Question'}]
}, {timestamps: true});

mongoose.model('User', UserSchema)