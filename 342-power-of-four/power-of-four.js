/**
 * @param {number} n
 * @return {boolean}
 */
var isPowerOfFour = function(n) {
    if(n<=0)
    return false;

    while(n%4===0){
        n/=4;
    }

    if(n===1)
    return true;

    else
    return false;
};