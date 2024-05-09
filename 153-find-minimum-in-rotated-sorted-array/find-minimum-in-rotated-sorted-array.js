/**
 * @param {number[]} nums
 * @return {number}
 */
var findMin = function(nums) {
    let left = 0;
    let right = nums.length-1;
    let min = Infinity;

    while(left<=right){
        let mid = Math.floor((left+right)/2);

        min = Math.min(min, nums[mid]);

        if(nums[left]<= nums[mid]){
            min = Math.min(min, nums[left]);
            left = mid+1;
        }

        else{
            min = Math.min(min, nums[mid]);
            right=mid-1;
        }
        
    }

    return min;
};