/**
 * @param {number[]} nums
 * @return {number}
 */
var findDuplicate = function(nums) {
    
    let hashmap = new Set();

    for(let i=0;i<nums.length;i++){

        if(hashmap.has(nums[i]))
        return nums[i];
        else{
            hashmap.add(nums[i]);
        }
    }
};