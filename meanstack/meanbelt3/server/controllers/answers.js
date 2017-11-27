const mongoose = require('mongoose');
const Answer = mongoose.model('Answer');
let num = 0;

module.exports = {
    index: (req, res)=>{
        Answer.find({})
        .populate('question_id')
        .exec((items, errors)=>{
            if(errors){
                res.send(errors);
            } else {
                res.json(answers);
            }
        }) 
    },
    
    //render a response
    create: (req, res) => {
        console.log(req.body)
        console.log("answer save successful!")
        console.log(req.params.id);
        const answer = new Answer(req.body)
        answer.answer_by = req.session.user_name
        answer.question_id = req.params.id
        answer.likes = num;
        console.log(answer.question_id)
        console.log(answer.answer_by)
        console.log(answer.like)
        answer.save((err) =>{
            if(err) {
                res.send(err)
            } else {
                res.send(answer);
            }
        })
    },
    find: (req, res) => {
        console.log('getting questions and answers!')
        console.log(req.params.id);
        Answer.find({ question_id: req.params.id })
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
    update: function(req, res) {
        console.log('11111111')
        console.log(req.params.id);
        console.log('22222222')
        console.log(req.body);
        console.log('3333333')
        const answer = new Answer(req.body)
        answer.likes++;
        console.log(answer.likes);
      Answer.update({ _id: req.params.id }, req.body, function(err, result){
          if (err) {
               console.log(err); 
          } else {
              console.log('made an update!')
          }
        });
  },
}
