//  TESTING FOR GITHUB
const mongoose = require('mongoose');
const Bucket = mongoose.model('Bucket');


module.exports = {

  create: (req, res) => {
    console.log("made it to CREATE bucket in controller");
    console.log(req.body);
    const bucket = new Bucket(req.body);
    bucket._user = req.session.user_id
    console.log(bucket._user)
    console.log("made it right before product.save");

    bucket.save((err) =>{
        if(err) {
            res.send(err);
        } else {
            res.json(bucket);
        }
    })
  },
  retrieve: (req, res) => {
    console.log("inside SHOW Bucket in express controller")
    Bucket.find({}, (buckets, error)=>{
        if(buckets){
            res.json(buckets)
        } else {
            res.send(error)
        }
    })
  },
  update: function(req, res) {
      console.log(req.params);
      console.log(req.params.id);
      console.log(req.body);
    Bucket.update({ _id: req.params.id }, req.body, function(err, result){
        if (err) {
             console.log(err); 
        } else {
            console.log('made an update!')
        }
      });
},

  delete: function(req, res) {
      console.log("delete bucket function hit!");
      console.log(req.params.id)
    Bucket.remove({ _id: req.params.id }, function(err, result){
        if (err) { console.log(err); }
    })
},
    findone:function(req, res) {
        console.log('finding item!')
        console.log(req.params.id)
        Bucket.findOne({ _id: req.params.id }).populate('_user') .exec (function(buckets, error){
            if (buckets) {
                res.json(buckets)
            } else {
                res.send(error)
            }
        })
    }
}
