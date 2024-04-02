/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var findMaxAverage = function(nums, k) {
    let sum = 0;
    let maxsum = -Infinity;
    let left = 0;
    let count = 0

    if(nums.length < k)
    return 0;

    for(let right=0; right<nums.length;right++){
        count++;
        sum+=nums[right];
        if(count===k){
            maxsum = Math.max(maxsum, sum);
            sum = sum-nums[left];
            left++;
            count--;
        }

    }

    return maxsum/k;
};