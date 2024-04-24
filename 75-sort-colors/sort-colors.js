/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var sortColors = function(nums) {
    let counta = 0;
    let countb = 0;
    let countc = 0;

    for(let i=0;i<nums.length;i++){
        if(nums[i] === 0)
        counta++;

        else if(nums[i]===1)
        countb++;

        else
        countc++;
    }

    for(let i=0;i<nums.length;i++){
        if(counta > 0)
        {nums[i] = 0;
        counta--;}

        else if(countb > 0){
            nums[i] = 1;
            countb--;
        }

        else{
            nums[i] = 2;
            countc--;
        }
    }
    
};