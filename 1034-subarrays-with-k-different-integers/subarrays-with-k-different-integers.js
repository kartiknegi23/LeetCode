/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var subarraysWithKDistinct = function(nums, k) {
    function atmax(nums, k){

    let left = 0;
    let count = 0;
    let unique = 0;
    let hashmap = new Map();

    if(k===0)
    return 0;

    for(let right =0; right<nums.length; right++){
        if(hashmap.has(nums[right]))
        hashmap.set(nums[right], hashmap.get(nums[right])+1);

        else
        {
            hashmap.set(nums[right], 1);
        }

        while(hashmap.size > k){
            hashmap.set(nums[left], hashmap.get(nums[left])-1);
            if(hashmap.get(nums[left])===0)
            hashmap.delete(nums[left]);
            left++;
        }

        count += right - left + 1;
    }
    return count;
    }
    return atmax(nums,k)-atmax(nums,k-1);
};