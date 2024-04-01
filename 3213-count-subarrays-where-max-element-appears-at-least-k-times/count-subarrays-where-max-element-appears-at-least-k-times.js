/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var countSubarrays = function(nums, k) {
    let left = 0;
    let count = 0;
    let max = -Infinity;
    let maxcount = 0;
    let mcount = 0;

    for(let i=0;i<nums.length;i++){
        if(max<nums[i])
        max = nums[i];
    }


    for(let right = 0; right<nums.length; right++){
        if(max === nums[right])
        mcount++;

        while(mcount >=k){
            if(nums[left]===max)
            mcount--;
            left++
        }
        count += right - left + 1;
    }

    return (nums.length*(nums.length+1))/2 - count;
};