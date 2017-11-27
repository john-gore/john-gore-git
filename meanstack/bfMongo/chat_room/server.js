var express = require("express");
// var session = require("express-session");
// var bodyParser = require('body-parser');
var path = require("path");

var app = express();

// app.use(session({secret: 'secret'}));
// app.use(bodyParser.urlencoded({extended: true}));
// app.use(express.json());
// app.use(express.static(__dirname + "/static"));
app.use(express.static(path.join(__dirname, "/static")));

// app.set('views', __dirname + '/views');
app.set('views', path.join(__dirname, '/views'));

app.set('view engine', 'ejs');

app.get('/', function(req, res){
    res.render('index');
})

var server = app.listen(8000, function(){
    console.log("listening on port 8000");
});
var io = require('socket.io').listen(server);

io.sockets.on('connection', function (socket){
    
    console.log("Client/socket is connected!");
    console.log("Client/socket id is: ", socket.id);
    socket.on("user", function(message){
        io.emit('server_response', message)
    })
    socket.on("send", function(message){
        io.emit('server_response', message);
    })
})