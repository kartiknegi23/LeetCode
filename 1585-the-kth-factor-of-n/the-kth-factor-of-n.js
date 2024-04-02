/**
 * @param {number} n
 * @param {number} k
 * @return {number}
 */
var kthFactor = function(n, k) {
    arr = [];
    for(let i=1;i<=n/2;i++){
        if(n%i===0)
        arr.push(i);
    }
    arr.push(n);
    if(arr.length < k)
    return -1;

    else
    return arr[k-1];
};