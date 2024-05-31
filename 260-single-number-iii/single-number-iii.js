/**
 * @param {number[]} nums
 * @return {number[]}
 */
var singleNumber = function(nums) {
    let xor = 0;
    for(let i=0;i<nums.length;i++){
        xor = xor^nums[i];
    }

    let rightmost = (xor&(xor-1))^xor;

    let bucket1=0;
    let bucket2=0;

    for(let i=0;i<nums.length;i++){
        if(nums[i]&rightmost)
        bucket1 = bucket1^nums[i];

        else
        bucket2 = bucket2^nums[i];
    }

    return [bucket1,bucket2];
};