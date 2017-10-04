function newarray(){
    var newArray = [];
        var i = 0;
        for(var i = 0; i < arr.length; i++){
       (typeof arr[i] === "number");
        newArray.push(arr[i]);
}
console.log(newArray);
}
var arr = [1,"bear",2,"plane",9];
newarray(arr);