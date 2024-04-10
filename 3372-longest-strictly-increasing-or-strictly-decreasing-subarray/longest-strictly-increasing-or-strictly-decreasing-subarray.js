/**
 * @param {number[]} nums
 * @return {number}
 */
var longestMonotonicSubarray = function(nums) {
    let countr = 1;
    let left = 0;
    let countl = 1;

    for(let right=1;right<nums.length;right++){
        if(nums[right] > nums[right-1]){
            countl = Math.max(countl, right-left+1);
            if(nums[right+1] <= nums[right])
            left = right;
        }

        else if(nums[right] < nums[right-1]){
            countr = Math.max(countr, right-left+1);
            if(nums[right+1] >= nums[right])
            left = right;
        }

        else{
            left = right;
        }
    }
    return Math.max(countl, countr);
};