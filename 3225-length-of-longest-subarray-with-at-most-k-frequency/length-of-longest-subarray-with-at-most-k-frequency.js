/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var maxSubarrayLength = function(nums, k) {
    let count = 0;
    let hashmap = new Map();
    let left = 0;

    for(let right=0;right<nums.length;right++){
        if(hashmap.has(nums[right])){
            hashmap.set(nums[right], hashmap.get(nums[right])+1);
        }

        else
        {
            hashmap.set(nums[right], 1);
        }
        
        while(hashmap.get(nums[right]) > k){
            hashmap.set(nums[left], hashmap.get(nums[left])-1);
            left++;
        }

        count = Math.max(count, right-left+1);
    }

    return count;
};