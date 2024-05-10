/**
 * @param {number[]} nums
 * @return {number}
 */
var findPeakElement = function(nums) {
    let low = 1;
    let high = nums.length-2;
    let n = nums.length;

    if(nums[0]>nums[1] || n===1)
    return 0;

    if(nums[n-1]>nums[n-2])
    return n-1;

    while(low<=high){
        let mid = Math.floor((low+high)/2);

        if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]){
            return mid;
        }

        else if(nums[mid]>nums[mid-1]){
            low = mid+1;
        }

        else{
            high = mid-1;
        }

    }
};