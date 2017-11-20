const mongoose = require('mongoose');
const Question = mongoose.model('Question');

module.exports = {
    retrieve: (req, res) => {
        console.log('in bike index')
    Question.find({}, (questions, error) =>{
        if(questions){
            res.json(questions);
        } else {
            res.send(error)
        }
    })
    },
    
    //render a response
    create: (req, res) => {
        console.log(req.body)
        console.log("bike save successful!")
        const question = new Question(req.body)
        question._user = req.session.user_id
        question.save((err) =>{
            if(err) {
                res.send(err)
            } else {
                res.send(question);
            }
        })
    },
}
