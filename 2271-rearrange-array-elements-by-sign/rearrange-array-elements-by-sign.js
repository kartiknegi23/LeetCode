/**
 * @param {number[]} nums
 * @return {number[]}
 */
var rearrangeArray = function(nums) {
    let pos = [];
    let neg = [];

    for(let i=0;i<nums.length;i++){
        if(nums[i]>0)
        pos.push(nums[i]);

        else
        neg.push(nums[i]);
    }

    console.log(pos, neg);

    let n=0;
    let p=0;

    for(let i=0;i<nums.length;i++){
        if(n===p){
            nums[i]=pos[p];
            p++;
        }

        else{
            nums[i]=neg[n];
            n++;
        }
    }

    return nums;
};