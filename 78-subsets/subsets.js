/**
 * @param {number[]} nums
 * @return {number[][]}
 */



var subsets = function(nums) {
    let ans = [];
    let n = nums.length;
    let arr = [];

    function sub(nums,arr,n,i){
        if(i>=n)
        {
            ans.push([...arr]);
            console.log(ans);
            return;
        }

        arr.push(nums[i]);
        sub(nums,arr,n,i+1);

        arr.pop();
        sub(nums,arr,n,i+1);
    }


    sub(nums,arr,n,0);

    return ans;    
};