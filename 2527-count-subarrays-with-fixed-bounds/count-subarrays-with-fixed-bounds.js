/**
 * @param {number[]} nums
 * @param {number} minK
 * @param {number} maxK
 * @return {number}
 */
var countSubarrays = function(nums, minK, maxK) {
    
    let left = right = badindex = -1;
    let count = 0; 

    for(let i=0;i<nums.length;i++){
        if(!(nums[i]>=minK && nums[i]<=maxK))
        badindex = i;

        if(nums[i]===minK)
        left = i;

        if(nums[i]===maxK)
        right = i;


        count+= Math.max(0, Math.min(left, right)-badindex);
    }

    return count;
};