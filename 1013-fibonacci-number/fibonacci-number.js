/**
 * @param {number} n
 * @return {number}
 */
var fib = function(n) {
    let arr = new Array();
    arr[0]=0;
    arr[1]=1;
    let ans=n;

    for(let i=2;i<=n;i++){
        arr[i] = arr[i-1] + arr[i-2];
        ans = arr[i];
    }
    return ans;
};