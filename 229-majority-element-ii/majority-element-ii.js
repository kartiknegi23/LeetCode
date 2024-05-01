/**
 * @param {number[]} nums
 * @return {number[]}
 */
var majorityElement = function(nums) {
    let hashmap = new Map();
    let ans = [];
    let n = nums.length;

    for(let i=0;i<nums.length;i++){
        if(hashmap.has(nums[i]))
        hashmap.set(nums[i],hashmap.get(nums[i])+1);

        else
        hashmap.set(nums[i], 1);
    }

    for([key, value] of hashmap){
        if(value>Math.floor(n/3))
        ans.push(key);
    }

    return ans;
};