/**
 * @param {number[]} nums
 * @return {number}
 */

function check(nums,mid){
    let count =0;
    for(let i=0;i<nums.length;i++){
        if(nums[i]>=mid)
        count++;
    }

    return count;
}


var specialArray = function(nums) {
    
    
    let low = 0;
    let high = nums.length;

    while(low<=high){
        let mid = Math.floor((low+high)/2);

        let count = check(nums,mid);

        if(count===mid)
        return count;

        else if(count>mid){
            low=mid+1;
        }

        else
        high=mid-1;
    }


    return -1;
};