const express = require('express');
const path = require('path');
const bodyParser = require('body-parser');
const PORT = 8888;

// new code:
const session = require('express-session');
// original code:
const app = express();
// more new code:
app.use(session({secret: 'codingdojorocks'}));  // string for encryption


app.use(express.static(path.join(__dirname, './public/dist')));
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended: true}));

require('./server/config/mongoose');
require('./server/config/routes')(app);


app.listen(PORT, ()=> {
    console.log(`Listening on port: ${PORT}`)
})