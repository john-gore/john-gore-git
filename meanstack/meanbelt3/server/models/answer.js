const mongoose = require('mongoose');
var Schema = mongoose.Schema;

const AnswerSchema = new mongoose.Schema({
    answer: String,
    details: String,
    likes: Number,
    answer_by: String,
    question_id: {type: Schema.Types.ObjectId, ref: 'Question'},
}, {timestamps: true});

mongoose.model('Answer', AnswerSchema)