const mongoose = require('mongoose');
const User = mongoose.model('User');

module.exports = {
    
    create: (req, res) =>{
        console.log(req.body)
        const user = new User(req.body)
        user.save((err) =>{
            if(err) {
                res.send(err);
            } else {
                
                // can access id here to put in session
                req.session.user_id = user._id;
                res.json(user);
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
