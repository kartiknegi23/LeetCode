/**
 * @param {number[]} nums
 * @return {number[]}
 */
var findDuplicates = function(nums) {
    
    let arr = [];

    nums.sort((a,b)=> a-b);

    console.log(nums);

    for(let i=0;i<nums.length-1;i++){
        console.log(nums[i], nums[i]+1);
        if(nums[i]==nums[i+1])
        arr.push(nums[i]);
    }

    return arr;
};