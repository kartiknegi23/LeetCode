/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var beautifulSubsets = function(nums, k) {

    let arr = [];
    count = 0;

    function sub(nums,arr,i){
        if(i>=nums.length)
        {   
            flag = true;
            outerloop:
            for(let i=0;i<arr.length;i++){
                let diff = 0;
                for(let j=i+1;j<arr.length;j++){
                    diff = Math.abs(arr[i]-arr[j]);
                    if(diff===k)
                    {
                    flag = false;
                    break outerloop;
                    }
                }
            }
            if(flag===true && arr.length!=0)
            count++;
            return;
        }

        arr.push(nums[i]);
        sub(nums,arr,i+1);

        arr.pop();
        sub(nums,arr,i+1);
    }

    sub(nums,arr,0);
    return count;
};