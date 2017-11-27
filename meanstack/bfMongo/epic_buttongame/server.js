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
    res.render('users')
})
app.post('/users', function (req, res){
    var users_array = 
    {'name' : req.body.name}
    res.render('results', {users_array})
  })
var server = app.listen(8000, function() {
  console.log("listening on port 8000");
  });
var io = require('socket.io').listen(server);
io.sockets.on('connection', function (socket) {
  console.log("Client/socket is connected!");
  console.log("Client/socket id is: ", socket.id);
  socket.on( "button_clicked", function (count){
    console.log(count)
  io.emit( "server_response", count);
  })
});  