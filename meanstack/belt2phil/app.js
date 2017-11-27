//Read this when setting up the backend structure!!! always make sure the model name is the correct name you want to use, also always make sure to have the correct Schema build and the models built to handle the information that we are given.


const express = require('express');
const path = require('path');
const bodyParser = require('body-parser');
const PORT = 8889;

// new code:
const session = require('express-session');
// original code:
const app = express();
// more new code:
app.use(session({secret: 'codingdojorocks'}));  // string for encryption

app.use(express.static(path.join(__dirname, './public/dist')));

app.use(bodyParser.json());
//used for ejs
app.use(bodyParser.urlencoded({extended: true}));
//used for angular

require('./server/config/mongoose');
require('./server/config/routes')(app);



app.listen(PORT, ()=>{
    console.log(`Listening on Port: ${PORT}!`)
})