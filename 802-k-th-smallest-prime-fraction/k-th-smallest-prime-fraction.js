/**
 * @param {number[]} arr
 * @param {number} k
 * @return {number[]}
 */
var kthSmallestPrimeFraction = function(arr, k) {
    let ans = [];

    for(let i=0;i<arr.length;i++){
        for(let j=arr.length-1;j>=i+1;j--){
            ans.push([arr[i],arr[j]]);
        }
    }

    
    ans.sort((a,b)=>a[0]/a[1] -b[0]/b[1]);
    return ans[k-1];
};