/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
function quicksort(nums,low,high){
    if(low<high){
        let pivot_index = find_index(nums,low,high);

        quicksort(nums,low,pivot_index-1);
        quicksort(nums,pivot_index+1,high);
    }
}

function find_index(nums,low,high){
    let i = low;
    let j= high;

    let pivot = nums[low];

    while(i<j){
        while(nums[i]<=pivot && i<=high-1)
        i++;

        while(nums[j]>pivot && j>=low+1)
        j--;

        if(i<j)
        {
            let temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    let temp = nums[low];
    nums[low] = nums[j];
    nums[j] = temp;
    
    return j;
}


var sortColors = function(nums) {
    
    quicksort(nums,0,nums.length-1);
};