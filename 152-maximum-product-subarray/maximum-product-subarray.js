/**
 * @param {number[]} nums
 * @return {number}
 */
var maxProduct = function(nums) {
    let max = -Infinity;
    let ans = [];
    for(let i=0;i<nums.length;i++){
        let product = 1;
        for(let j=i;j<nums.length;j++){
            product=product*nums[j];
            max = Math.max(max, product);
        }
    }

    return max;
};