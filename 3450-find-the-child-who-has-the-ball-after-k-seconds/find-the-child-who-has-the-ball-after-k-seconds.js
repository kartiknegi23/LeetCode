/**
 * @param {number} n
 * @param {number} k
 * @return {number}
 */
var numberOfChild = function(n, k) {
    let rounds = Math.floor(k/(n-1));
    let remainder = k%(n-1);

    if(rounds%2===0)
    return remainder;

    else
    return n-1-remainder;
};