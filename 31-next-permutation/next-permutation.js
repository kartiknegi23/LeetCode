/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */

function reversesection(arr,j,n){
    let left=j;
    let right=n;
    while(left<right){
        let temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;

        left++;
        right--;
    }
}

var nextPermutation = function(nums) {
    
    let pos = -1;

    for(let i=nums.length-2;i>=0;i--){
        if(nums[i]<nums[i+1]){
            pos = i;
            break;
        }
    }

    if(pos===-1)
    return nums.reverse();

    for(let i=nums.length-1;i>=pos;i--){
        if(nums[i]>nums[pos]){
            let temp = nums[i];
            nums[i] = nums[pos];
            nums[pos] = temp;
            break;
        }
    }

    reversesection(nums,pos+1,nums.length-1)
    return nums;
};