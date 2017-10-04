function random(x){
    while(x > 0){
        x--;
        if(Math.random() < .01){
            x+=Math.floor(Math.random() * 50) + 50;
            return x;
        }
    }
    return x;
}
console.log(random(100));