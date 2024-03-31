/**
 * @param {number[]} nums
 * @param {number} k
 * @return {boolean}
 */
var containsNearbyDuplicate = function(nums, k) {
    let left = 0;
    let hashmap = new Map();

    for(let i = 0; i<nums.length;i++){
        if(hashmap.has(nums[i]) && Math.abs(i-hashmap.get(nums[i])) <=k){
            return true;
        }
        else{
            hashmap.set(nums[i], i);
        }
    }

    return false;
};