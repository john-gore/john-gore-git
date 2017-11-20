const players = require('./../controllers/players');

module.exports = (app)=>{
    app.get('/players', players.index);
    app.post('/players', players.create);
    app.delete('/players/delete/:id', players.delete);
    };
