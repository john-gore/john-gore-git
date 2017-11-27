module.exports = function (){
    return {
    add: function(num1, num2) { 
        var x = num1;
        var y = num2;
        console.log(x + y);
    },
    multiply: function(num1, num2) {
        var x = num1;
        var y = num2;
        var z = (x + y);
        console.log(z)
    },
    square: function(num) {
        var x = num;
        var y = (num * num);
        console.log(y)
    },
    random: function(num1, num2) {
        var x = num1;
        var y = num2;
        console.log(Math.floor(Math.random() * num2) + num1)
    }
    }
};