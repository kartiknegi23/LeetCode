/**
 * @param {number[]} nums
 * @param {number} threshold
 * @return {number}
 */

function calculate(nums, mid){
    let sum = 0;
    for(let i=0;i<nums.length;i++){
        sum+= Math.ceil(nums[i]/mid);
    }

    return sum;
}

var smallestDivisor = function(nums, threshold) {

    let max = -Infinity;
    let ans;

    for(let i=0;i<nums.length;i++){
        if(max<nums[i])
        max=nums[i];
    }

    let low = 1;
    let high = max;

    while(low<=high){
        let mid = Math.floor((low+high)/2);

        let sum = calculate(nums, mid);

        if(sum<=threshold){
            ans = mid;
            high = mid-1;
        }

        else{
            low=mid+1;
        }
    }

    return ans;
};