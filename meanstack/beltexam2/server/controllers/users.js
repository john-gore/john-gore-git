const mongoose = require('mongoose');
const User = mongoose.model('User');

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
    
    show: (req, res) => {
        console.log("inside SHOW USERS in express controller")
        User.find({}, (users, error)=>{
            if(users){
                res.json(users)
            } else {
                res.send(error)
            }
        })
      },

    auth: (req, res) => {
        User.findOne({
            email: req.body.email}, (user, error) =>{
                if(user) {
                   if (user.password === req.body.password) {
                    req.session.user_id = user._id   
                    res.json(user)
                   } else {
                       res.send('Authentication Failed')
                    }
                }
                else {
                   res.send('false');
               }
            })
    }
}
