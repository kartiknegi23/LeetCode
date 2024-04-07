/**
 * @param {number[]} nums
 * @return {number}
 */
var longestMonotonicSubarray = function(nums) {
    let left = 0;
    let start = 0;
    let countl= 1;
    let countr = 1
    
    for(let right=1; right<nums.length;right++){
        if(nums[right] > nums[left]){
            left++;
            countl=Math.max(countl, right-start+1);
            if(nums[right+1]<=nums[right])
                start = right;
            continue;
        }
        
        else if(nums[right] < nums[left]){
            left++;
            countr=Math.max(countr, right-start+1);
            if(nums[right+1]>=nums[right])
                start = right;
            continue;
        }
        
        else{
        while(nums[right]===nums[left] && left<right){
            start++;
            left++;
        }
        }
        
    }
        return Math.max(countl,countr);
};