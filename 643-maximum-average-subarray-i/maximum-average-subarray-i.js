/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var findMaxAverage = function(nums, k) {
    let sum = 0;
    let count = 0;
    let left = 0;
    let sums = [];
    let high = -Infinity;

    for(let right = 0;right<nums.length;right++){
        sum+=nums[right];
        count++;

        if(count===k){
            sums.push(sum);
            sum-=nums[left];
            left++;
            count--;
        }
    }


    for(let i=0;i<sums.length;i++){
        if(high<sums[i])
        high=sums[i];
    }

    

    return high/k;
};