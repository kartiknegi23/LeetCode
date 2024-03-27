/**
 * @param {number[]} nums
 * @return {number}
 */
var firstMissingPositive = function(nums) {
    
    for(let i=0;i<nums.length;i++){
        while(nums[i] > 0 && nums[i] <= nums.length && nums[nums[i]-1]!==nums[i]){
            let temp = nums[i];
            nums[i] = nums[nums[i]-1]; 
            nums[temp-1] = temp;
        }
    }

    for(let i=0;i<nums.length;i++){
        if(i!=nums[i]-1)
        return i+1;
    }

    return nums.length+1;

};