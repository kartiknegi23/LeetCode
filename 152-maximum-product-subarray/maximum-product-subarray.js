/**
 * @param {number[]} nums
 * @return {number}
 */
var maxProduct = function(nums) {
    let prefix = 1;
    let suffix = 1;
    let max = -Infinity;
    let n = nums.length;

    for(let i=0;i<nums.length;i++){
        if(prefix===0)
        prefix=1;

        if(suffix===0)
        suffix=1;

        prefix=prefix*nums[i];
        suffix=suffix*nums[n-1-i];

        max = Math.max(max, Math.max(prefix,suffix));
        console.log(max, prefix, suffix);

    }

    return max;
};