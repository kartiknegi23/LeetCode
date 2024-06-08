/**
 * @param {number[]} nums
 * @param {number} k
 * @return {boolean}
 */
var checkSubarraySum = function(nums, k) {
    if(nums.length<2)
    return false;

    let sum = 0;
    let hashmap = new Map();
    hashmap.set(0,-1);

    for(let i=0;i<nums.length;i++){
        sum+=nums[i];
        if(hashmap.has(sum%k)){
            let oldindex = hashmap.get(sum%k);
            let diff = i-oldindex;
            if(diff>=2)
            return true;
        }
        else{
            hashmap.set(sum%k, i);
        }
    }
    return false;
};