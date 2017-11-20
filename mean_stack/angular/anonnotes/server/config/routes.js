const notes = require('./../controllers/notes');

module.exports = (app)=>{
    app.get('/notes', notes.index);
    app.post('/notes', notes.create);
    };
