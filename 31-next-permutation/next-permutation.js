/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */

function reversearr(nums,left,right){
    let i=left;
    let j=right;

    while(i<j){
        let temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
        i++;
        j--;
    }
}

var nextPermutation = function(nums) {
    let pos = -1;
    let n = nums.length-1;

    for(let i=nums.length-2;i>=0;i--){
        if(nums[i]<nums[i+1]){
            pos=i;
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

    reversearr(nums,pos+1,n);

    return nums;  
};