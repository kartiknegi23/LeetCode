/**
 * @param {number} n
 * @return {boolean}
 */
var isPowerOfThree = function(n) {
    if(n<=0 || n==2)
    return false;

    while(n%3===0){
        n=n/3;
    }
    return n===1;
};