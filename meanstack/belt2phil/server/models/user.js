const mongoose = require('mongoose');
var Schema = mongoose.Schema;

const UserSchema = new mongoose.Schema({
    name: {type:String, required: true}
}, {timestamps: true});

mongoose.model('User', UserSchema)