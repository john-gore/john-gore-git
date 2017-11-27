const mongoose = require('mongoose');
const Note = mongoose.model('Note');

module.exports = {
    index: (req, res) =>{
        console.log('in index')
    //retrieve all users
    Note.find({}, (notes, error)=>{
        if(notes){
            res.json(notes);
        } else{
            res.send(error)
            }
        })
    },
    
    //render a response
    create: (req, res)=>{
        console.log(req.body)
        const note = new Note(req.body)
        note.save((err)=>{
            if(err) {
                res.send(err);
            } else {
                res.send(note);
            }
        })
    } 
}
