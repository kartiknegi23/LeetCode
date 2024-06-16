/**
 * @param {number[]} nums
 * @param {number} n
 * @return {number}
 */
var minPatches = function(nums, n) {
    let count = 0;
    let sum=0;
    let i=0;

    while(sum<n){
        if(nums[i]<=sum+1)
        {
            sum += nums[i];
            i++;
        }

        else{
            sum = sum+sum+1;
            count++;
        }
    }
    return count;
};