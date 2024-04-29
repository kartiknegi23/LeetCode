/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var minOperations = function(nums, k) {
    let xor=nums[0]^nums[1];
    let count = 0;

    for(let i=2;i<nums.length;i++){
        xor=xor^nums[i];
    }

    ans = xor.toString(2);

    k = k.toString(2);

    console.log(xor, ans, k);

    while(ans.length!=k.length){
        if(ans.length<k.length)
        ans="0"+ans;

        else if(k.length<ans.length)
        k="0"+k;
    }

    for(let i=ans.length-1;i>=0;i--){
        if(ans[i]!=k[i])
        count++;
    }



    return count;
};