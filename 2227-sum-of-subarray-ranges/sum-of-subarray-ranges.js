/**
 * @param {number[]} nums
 * @return {number}
 */
var subArrayRanges = function(nums) {
    let left_minimum = new Array(nums.length);
    let right_minimum = new Array(nums.length);
    let minimum_sum = 0;
    let MOD = 1000000007;
    let stack = [];

    for(let i=0;i<nums.length;i++){
        while(stack.length>0 && nums[i]<=nums[stack[stack.length-1]])
        stack.pop();

        if(stack.length===0)
        left_minimum[i]= -1;

        else
        left_minimum[i] = stack[stack.length-1];

        stack.push(i);
    }

    stack = [];

    for(let i=nums.length-1;i>=0;i--){
        while(stack.length>0 && nums[i]<nums[stack[stack.length-1]])
        stack.pop();

        if(stack.length===0)
        right_minimum[i] = nums.length;

        else
        right_minimum[i] = stack[stack.length-1];

        stack.push(i);
    }


    for(let i=0;i<nums.length;i++){
        let left_sum = i-left_minimum[i];
        let right_sum = right_minimum[i] - i;
        let product = left_sum*right_sum;
        let total_sub = nums[i]*product;
        minimum_sum = (minimum_sum+total_sub);
    }

    stack = [];
    let left_maximum = new Array(nums.length);
    let right_maximum = new Array(nums.length);
    let maximum_sum = 0;

    for(let i=0;i<nums.length;i++){
        while(stack.length>0 && nums[i]>=nums[stack[stack.length-1]])
        stack.pop();

        if(stack.length===0)
        left_maximum[i] = -1;

        else
        left_maximum[i] = stack[stack.length-1];

        stack.push(i);
    }


    stack = [];

    for(let i=nums.length-1;i>=0;i--){
        while(stack.length>0 && nums[i]>nums[stack[stack.length-1]])
        stack.pop();

        if(stack.length===0)
        right_maximum[i] = nums.length;

        else
        right_maximum[i] = stack[stack.length-1];

        stack.push(i);
    }


    for(let i=0;i<nums.length;i++){
        let left_sum = i-left_maximum[i];
        let right_sum = right_maximum[i] - i;
        let total_sub = left_sum*right_sum;
        let product = nums[i]*total_sub;
        maximum_sum = (maximum_sum+product);
    }


    return maximum_sum-minimum_sum;
};