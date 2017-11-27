var express = require("express");
var session = require('express-session');
var app = express();
var bodyParser = require('body-parser');
var path = require("path");
app.use(bodyParser.urlencoded({extended: true}));
app.use(session({secret: 'codingdojorocks'}));
app.use(express.json());
app.use(express.static(path.join(__dirname, "/static")));


app.set('views', __dirname + '/views'); 

app.set('view engine', 'ejs');
app.get("/", function (req, res){
    res.render('users')
})

var server = app.listen(8000, function() {
    console.log("listening on port 8000");
})

var io = require('socket.io').listen(server);
io.sockets.on('connection', function (socket){
  console.log("We have a connection");
  socket.on("user", function(message){
    io.emit('server_response', message);
  })
  socket.on("send", function(message){
    io.emit('server_response', message);
  })
})
  