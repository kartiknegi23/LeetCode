/**
 * @param {number[]} nums
 * @return {number}
 */
var maxSubArray = function(nums) {
    let sum = 0;
    let maxi = -Infinity;
    let sub = [];
    let start = -1;
    let end = -1;

    for(let i=0;i<nums.length;i++){
        if(sum===0){
            start = i;
        }


        sum+=nums[i];

        if(maxi<sum)
        {
            maxi = sum;
            end = i;
        }

        if(sum<0)
        sum=0;
    }

    for(let i=start;i<=end;i++){
        sub.push(nums[i]);
    }

    console.log(sub);
    return maxi;
};