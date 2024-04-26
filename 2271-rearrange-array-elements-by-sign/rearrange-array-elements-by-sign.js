/**
 * @param {number[]} nums
 * @return {number[]}
 */
var rearrangeArray = function(nums) {  

    let ans = [];
    let pos = 0;
    let neg = 1;

    for(let i=0;i<nums.length;i++){
        if(nums[i]<0){
            ans[neg]=nums[i];
            neg+=2;
        }

        else{
            ans[pos]=nums[i];
            pos+=2;
        }
    }
    return ans;
};