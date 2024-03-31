/**
 * @param {number[]} nums
 * @return {number}
 */
var findLHS = function(nums) {
    let hashmap = new Map();
    let count = 0;
    for(let i=0;i<nums.length;i++){
        if(hashmap.has(nums[i]))
        hashmap.set(nums[i], hashmap.get(nums[i])+1);

        else
        hashmap.set(nums[i], 1);
    }

    for(let i=0; i<nums.length;i++){
        if(hashmap.has(nums[i]+1))
        count=Math.max(count, hashmap.get(nums[i]) + hashmap.get(nums[i]+1));
    }

    return count;
};