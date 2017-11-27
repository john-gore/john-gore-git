
var express = require("express");
var session = require('express-session');
var app = express();
app.use(session({secret: 'codingdojorocks'}));

// app.use(express.static(__dirname + "/static"));

app.set('views', __dirname + '/views'); 

app.set('view engine', 'ejs');
app.get("/", function (request, response){
    var count = 0;
    if(request.session.count === undefined){ 
        request.session.count = 0;
    }
    else{
        request.session.count += 1;
    }
    console.log(request.session.count)
    response.render('users', {count: request.session.count});
})
app.post('/by-two', function (request, response){
    request.session.count += 1;
    response.redirect('/')
})
app.post('/reset', function (request, response){
    delete (request.session.count);
    response.redirect('/')
})

app.listen(8000, function() {
    console.log("listening on port 8000");
  })
 
  