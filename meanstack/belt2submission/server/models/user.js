const mongoose = require('mongoose');
var Schema = mongoose.Schema;

const UserSchema = new mongoose.Schema({
    name: String,
    lists: [{type: Schema.Types.ObjectId, ref: 'Bucket'}]
}, {timestamps: true});

mongoose.model('User', UserSchema)