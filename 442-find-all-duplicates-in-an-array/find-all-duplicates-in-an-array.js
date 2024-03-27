/**
 * @param {number[]} nums
 * @return {number[]}
 */
var findDuplicates = function(nums) {
    
    let arr = [];

    let hashmap = new Map();

    for(let i=0;i<nums.length;i++){
        if(hashmap.has(nums[i]))
        hashmap.set(nums[i], hashmap.get(nums[i])+1)
        else
        hashmap.set(nums[i], 1);
    }

    console.log(hashmap);

    for(let [key, value] of hashmap){
        if(value === 2)
        arr.push(key);
    }

    return arr;
};