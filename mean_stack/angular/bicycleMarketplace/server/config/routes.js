const users = require('./../controllers/users');
const bikes = require('./../controllers/bikes');

module.exports = (app) =>{
    //routes for users
    app.post('/users/create', users.create);
    app.post('/users/auth', users.auth);
    app.get('/bikes', bikes.retrieve);
    app.post('/bikes/create', bikes.create);
    app.post('/bikes/update/:id', bikes.update);
    app.post('/bikes/delete/:id', bikes.delete);
    //routes for bikes
}