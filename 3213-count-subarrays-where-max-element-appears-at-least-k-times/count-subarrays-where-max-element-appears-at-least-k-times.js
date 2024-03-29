/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var countSubarrays = function(nums, k) {
    let left = 0;
    let max = -Infinity;
    let maxcount = 0;
    let count = 0;
    let kcount = 0;

    for(let i=0;i<nums.length;i++){
        if(max < nums[i])
        max = nums[i];
    }

    for(let i=0;i<nums.length;i++){
        if(max === nums[i])
        maxcount++;
    }

    if(maxcount < k)
    return 0;

    for(let right=0; right<nums.length; right++){
        if(nums[right]===max)
        kcount++;

        while(kcount >= k){
            if(nums[left]==max)
            kcount--;
            left++;
        }

        count = count + right - left + 1;
    }

    return ((nums.length*(nums.length+1))/2)-count;
};