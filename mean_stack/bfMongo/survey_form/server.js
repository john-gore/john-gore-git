var express = require("express");
var session = require('express-session');
var app = express();
var bodyParser = require('body-parser');
app.use(bodyParser.urlencoded({extended: true}));
app.use(session({secret: 'codingdojorocks'}));
app.use(express.json());

app.set('views', __dirname + '/views'); 

app.set('view engine', 'ejs');
app.get("/", function (req, res){
    console.log(2)
    res.render('users')
})
app.post('/users', function (req, res){
    var users_array = 
    {'name' : req.body.name , 'location' : req.body.location, 'language' : req.body.language,
    'comment' : req.body.comment}  
    
    res.render('results', {users_array})
  })
app.listen(8000, function() {
    console.log("listening on port 8000");
  })
 
  