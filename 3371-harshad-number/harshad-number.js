/**
 * @param {number} x
 * @return {number}
 */
var sumOfTheDigitsOfHarshadNumber = function(x) {
    let sum = 0;
    let temp = x;
    
    while(temp > 0)
    {
    sum = sum+temp%10;
    temp = Math.floor(temp/10);
    }
    
    if(x%sum===0){
        return sum;
    }
    else
        return -1;
};