const mongoose = require('mongoose');
var Schema = mongoose.Schema;

const QuestionSchema = new mongoose.Schema({
    question: String,
    description: String,
    answers: Number,
    created_by: {type: Schema.Types.ObjectId, ref: 'User'},
    _answer: {type: Schema.Types.ObjectId, ref: 'Answer'},
}, {timestamps: true});

mongoose.model('Question', QuestionSchema)