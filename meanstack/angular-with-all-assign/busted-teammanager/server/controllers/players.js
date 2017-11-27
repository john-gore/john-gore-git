const mongoose = require('mongoose');
const Player = mongoose.model('Player');

module.exports = {
    index: (req, res) =>{
        console.log('in index')
    //retrieve all users
    Player.find({}, (players, error)=>{
        if(players){
            res.json(players);
        } else{
            res.send(error)
            }
        })
    },

    //render a response
    create: (req, res)=>{
        console.log(req.body)
        const player = new Player(req.body)
        player.save((err)=>{
            if(err) {
                res.send(err);
            } else {
                res.send(player);
            }
        })
    },
    delete: (req, res)=>{
        console.log('//////**/////')
        console.log(req.body);
        console.log(req.params);
        Player.remove({ _id: req.params.id }).then((resp)=>{
            res.send(resp);
        }
    )
          console.log('its deleted!!!!'); 
    }
}
