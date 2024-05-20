/**
 * @param {number[]} nums
 * @return {number}
 */
var subsetXORSum = function(nums) {
    let sum = 0;   
    let n = nums.length;
    let arr = [];

    function sub(nums,n,arr,i){
        if(i>=n)
        return;

        let xor = 0;
        arr.push(nums[i]);
        for(let j=0;j<arr.length;j++){
            xor= xor^arr[j];
        }
        sum+=xor;
        sub(nums,n,arr,i+1);

        arr.pop();
        sub(nums,n,arr,i+1);
    }

    sub(nums,n,arr,0);

    return sum;
};