/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */

function check(nums,mid){
    let count = 1;
    let sum = 0;
    for(let i=0;i<nums.length;i++){
        sum+=nums[i];
        if(sum>mid){
            count++;
            sum=nums[i];
        }
    }
    return count;
}

var splitArray = function(nums, k) {
    let sum = 0;
    let min = -Infinity;
    let ans = 0;

    if(k>nums.length)
    return -1;

    for(let i=0;i<nums.length;i++){
        sum+=nums[i];

        min = min<nums[i] ? nums[i] : min;
    }

    let low = min;
    let high = sum;

    while(low<=high){
        let mid = Math.floor((low+high)/2);

        let count = check(nums,mid);

        if(count<=k){
            ans = mid;
            high=mid-1;
        }

        else
        low=mid+1;
    }

    return ans;
};