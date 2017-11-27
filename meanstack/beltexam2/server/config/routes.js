const users = require('./../controllers/users');
const buckets = require('./../controllers/buckets');

module.exports = (app)=>{
    app.get('/users', users.index);
    app.post('/users', users.create);

    // app.all("*", (req,res,next) => {
    //     res.sendFile(path.resolve("./public/dist/index.html"))
    // });
    };
