/**
 * @param {number[]} nums
 * @return {number}
 */
var specialArray = function(nums) {
    
    
    let ans = 0;

    for(let i=0;i<=nums.length;i++){
        let count = 0;
        for(let j=0;j<nums.length;j++){
            if(nums[j]>=i)
            count++;
        }
        if(count===i)
        return count;
    }

    return -1;

};