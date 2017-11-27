const users = require('./../controllers/users');
const questions = require('./../controllers/questions');
const answers = require('./../controllers/answers');

module.exports = (app)=>{
    app.get('/users', users.index);
    app.post('/users', users.create);
    app.get('/logout', users.logout);
    app.get('/questions', questions.index);
    app.get('/questions/:id', questions.findone);
    app.post('/questions/create', questions.create);
    app.get('/answers', answers.index);
    app.get('/answers/:id', answers.find);
    app.post('/answers/like/:id', answers.update);
    app.post('/answers/create/:id', answers.create);
    };
