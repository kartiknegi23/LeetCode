/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var searchRange = function(nums, target) {
    let left = 0;
    let right = nums.length-1;

    let start = -1;
    let end = -1;

    while(left<=right){
        let mid = Math.floor((left+right)/2);

        if(nums[mid]===target){
            if(nums[mid-1]!==target){
                start = mid;
                break;
            }
            else{
                right=mid-1;
            }
        }

        else if(target<nums[mid]){
            right=mid-1;
        }

        else{
            left=mid+1;
        }
    }

    left = 0;
    right = nums.length-1;

    while(left<=right){
        let mid = Math.floor((left+right)/2);

        if(nums[mid]===target){
            if(nums[mid+1]!==target){
                end = mid;
                break;
            }
            else{
                left=mid+1;
            }
        }

        else if(target>nums[mid]){
            left=mid+1;
        }

        else{
            right=mid-1;
        }
    }

    return [start,end];
};