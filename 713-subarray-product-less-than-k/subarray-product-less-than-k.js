/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var numSubarrayProductLessThanK = function(nums, k) {
    let product = 1;
    let count = 0;

    for(let i=0;i<nums.length;i++){
        if(nums[i]<k)
        {
            product = nums[i];
            count++;
        }
        else
        continue;
        for(let j=i+1;j<nums.length;j++){
            product = product*nums[j];
            if(product<k)
            count++;
            else
            break;
        }
    }

    return count;
};