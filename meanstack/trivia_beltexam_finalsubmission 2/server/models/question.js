const mongoose = require('mongoose');
var Schema = mongoose.Schema;

const QuestionSchema = new mongoose.Schema({
    question: String,
    correct_answer: String,
    false_answer1: String,
    false_answer2: String,
    _user: {type: Schema.Types.ObjectId, ref: 'User'},
}, {timestamps: true});

mongoose.model('Question', QuestionSchema)