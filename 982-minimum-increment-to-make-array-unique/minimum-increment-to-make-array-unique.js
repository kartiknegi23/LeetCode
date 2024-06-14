/**
 * @param {number[]} nums
 * @return {number}
 */
var minIncrementForUnique = function(nums) {
    let count = 0;
    let hashmap = new Map();
    let arr = new Array(nums.length);

    nums.sort((a,b)=>a-b);

    for(let i=0;i<nums.length;i++){
        if(hashmap.has(nums[i])){
            let sum = nums[i] + Math.abs(nums[i]-arr[i-1])+1;
            count+= sum-nums[i];
            arr[i] = sum;
            hashmap.set(sum, 1);
        }

        else{
            hashmap.set(nums[i], 1);
            arr[i] = nums[i];
        }
    }

    return count;
};