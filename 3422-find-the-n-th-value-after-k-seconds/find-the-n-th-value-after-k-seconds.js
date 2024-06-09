/**
 * @param {number} n
 * @param {number} k
 * @return {number}
 */
var valueAfterKSeconds = function(n, k) {
    let prefix = new Array(n).fill(1);
    const MOD = 1000000007
    let sum=0;
    let count = 0;

    while(count<k)
    {
        for(let i=1;i<n;i++)
        {
            prefix[i] = (prefix[i-1]+prefix[i])% MOD;
        }
    count++;
    }

    return (prefix[n-1])%(10e9 + 7);
};