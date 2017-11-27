const mongoose = require('mongoose');
var Schema = mongoose.Schema;

const ItemSchema = new mongoose.Schema({
    title: {type: String, required: true, minlength: 5},
    description: {type: String, required: true, minlength: 10},
    created_by: {type: Schema.Types.ObjectId, ref: 'User'},
}, {timestamps: true});

mongoose.model('Item', ItemSchema)