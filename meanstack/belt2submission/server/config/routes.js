const users = require('./../controllers/users');
const buckets = require('./../controllers/buckets');

module.exports = (app)=>{
    app.get('/users', users.index);
    app.post('/users', users.create);
    app.post('/users/update/:id', users.update);
    app.get('/buckets', buckets.retrieve);
    app.post('/buckets/create', buckets.create);
    app.get('/user/:id', users.findone);
    app.get('/buckets/:id', buckets.findone);
    };
