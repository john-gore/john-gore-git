const mongoose = require('mongoose');
var Schema = mongoose.Schema;

const BikeSchema = new mongoose.Schema({
    title: String,
    image: String,
    description: String,
    price: Number,
    location: String,
    _user: {type: Schema.Types.ObjectId, ref: 'User'},
}, { timestamps: true });

mongoose.model('Bike', BikeSchema)