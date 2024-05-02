/**
 * @param {number[]} nums
 * @return {number}
 */
var findMaxK = function(nums) {
    let max = -Infinity;
    let map = new Set();

    for(let i=0;i<nums.length;i++){
        map.add(nums[i]);

        if(max < Math.abs(nums[i]) && map.has(0-nums[i]))
        {   
            max=Math.abs(nums[i]);

            console.log(max, nums[i]);

        }
    }
    if(max===-Infinity)
    return -1

    else
    return max;
};