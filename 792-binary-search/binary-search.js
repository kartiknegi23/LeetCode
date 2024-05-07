/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function(nums, target) {
    let index = -1;

    let left = 0;
    let right = nums.length-1;


    while(left<=right){
        let mid = Math.floor((left+right)/2);
        if(target>nums[mid]){
            left=mid+1;
        }

        if(target<nums[mid]){
            right=mid-1;
        }

        else if(target===nums[mid]){
            return mid;
        }

    }
    return index;
};