/**
 * @param {number} n
 * @return {boolean}
 */
var isPowerOfTwo = function(n) {
    if(n<=0)
    return false

    return (Math.floor(Math.log2(n)/Math.log2(2)) === Math.ceil(Math.log2(n)/Math.log2(2)))

};