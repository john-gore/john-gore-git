const mongoose = require('mongoose');
const Bike = mongoose.model('Bike');

module.exports = {
    retrieve: (req, res) => {
        console.log('in bike index')
    Bike.find({}, (bikes, error) =>{
        if(bikes){
            res.json(bikes);
        } else {
            res.send(error)
        }
    })
    },

    create: (req, res) => {
        console.log(req.body)
        console.log("bike save successful!")
        const bike = new Bike(req.body)
        bike._user = req.session.user_id
        bike.save((err) =>{
            if(err) {
                res.send(err)
            } else {
                res.send(bike);
            }
        })
    },
    update: (req, res) =>{
        console.log('in updates')
        Bike.updateOne({_id: req.params.id}, req.body, (bike, error) => {
            if(error) {
                res.send(error)
            } else {
                res.send(bike);
            }
        }
        )
    },

    delete: (req, res) => {
        console.log('delete worked!')
        Bike.remove({_id: req.params.id}, (bike, error) => {
            if (error) {
                res.send(error)
            } else {
                res.send('Bike Deleted!!!')
            }
        })
    },
}