const users = require('./../controllers/users');
const questions = require('./../controllers/questions');

module.exports = (app)=>{
    app.get('/users', users.index);
    app.post('/users', users.create);
    app.post('/users/update/:id', users.update);
    app.get('/questions', questions.retrieve);
    app.post('/questions/create', questions.create);
    };
