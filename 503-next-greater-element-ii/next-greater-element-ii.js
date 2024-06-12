/**
 * @param {number[]} nums
 * @return {number[]}
 */
var nextGreaterElements = function (nums) {
    let stack = [];
    let arr = new Array(nums.length);
    let n = nums.length;

    for (let i = (2*n)-1; i>=0;i--){

        while(stack.length>0 && nums[i%n]>=stack[stack.length-1]){
            stack.pop();
        }

        if(i<n)
        {if(stack.length>0)
        arr[i] = stack[stack.length-1];

        else
        arr[i] = -1;}

        stack.push(nums[i%n]);

    }  

    return arr;
};