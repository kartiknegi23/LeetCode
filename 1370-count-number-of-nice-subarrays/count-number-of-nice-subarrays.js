/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var numberOfSubarrays = function(nums, k) {
    let odd_count = 0;
    let count = 0;
    let result = 0;
    let low = 0;
    let high = 0;

    while(high<nums.length){
        if(nums[high]%2!==0)
        {   
            count=0;
            odd_count++;
        }

        while(odd_count===k){
            count++;
            if(low<nums.length && nums[low]%2===1)
            odd_count--;

            low++;
        }
        result+=count;

        high++;
    }
    return result;
};