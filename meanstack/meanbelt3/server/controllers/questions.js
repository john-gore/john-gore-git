const mongoose = require('mongoose');
const Question = mongoose.model('Question');
let num = 0;

module.exports = {
    index: (req, res)=>{
        Question.find({})
        .populate('created_by')
        .exec((items, errors)=>{
            if(errors){
                res.send(errors);
            } else {
                res.json(questions);
            }
        }) 
    },
    
    //render a response
    create: (req, res) => {
        console.log(req.body)
        console.log("question save successful!")
        const question = new Question(req.body)
        question.answers = num;
        console.log(question.answers)
        question.created_by = req.session.user_id
        question.save((err) =>{
            if(err) {
                res.send(err)
            } else {
                res.send(question);
            }
        })
    },
    
    findone: (req, res) => {
        console.log('getting questions and answers!')
        console.log(req.params.id);
        Question.findOne({ _id: req.params.id })
            .populate('_answer')
            .exec((error, questions) => {
            if (questions) {
                res.json(questions)
                console.log(questions)
            } else {
                res.send(error)
            }
        })
    },
}
