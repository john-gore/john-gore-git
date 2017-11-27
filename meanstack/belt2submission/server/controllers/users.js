const mongoose = require('mongoose');
const User = mongoose.model('User');
const Bucket = mongoose.model('Bucket');


module.exports = {
    
    index: (req, res) =>{
        console.log('in index')
    //retrieve all users
    User.find({}, (users, error)=>{
        if(users){
            res.json(users);
        } else{
            res.send(error)
            }
        })
    },
    //render a response
    create: (req, res) =>{
        console.log(req.body)
        const user = new User(req.body)
        user.save((err) =>{
            if(err) {
                res.send(err);
            } else {
                console.log("User save successful")
                // can access id here to put in session
                req.session.user_id = user._id;
                res.json(user);
            }
        })
    },
    update: (req, res) =>{
        console.log('in updates')
        User.updateOne({_id: req.params.id}, req.body, (user, error) => {
            if(error) {
                res.send(error)
            } else {
                res.send(user);
            }
        }
        )
    },
    findone: function(req, res) {
        console.log('finding user!')
        console.log(req.params.id)
        User.findOne({ _id: req.params.id }).populate('lists') .exec(function (error, user) {
            if (user) {
                res.json(user)
            } else {
                res.send(error)
            }
        })
    }

}
