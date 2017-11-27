const mongoose = require('mongoose');
var Schema = mongoose.Schema;

const BucketSchema = new mongoose.Schema({
    title: String,
    description: String,
    _user: {type: Schema.Types.ObjectId, ref: 'User'},
}, { timestamps: true });

mongoose.model('Bucket', BucketSchema)