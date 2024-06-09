/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var subarraysDivByK = function(nums, k) {
    let count = 0;
    let hashmap = new Map();
    hashmap.set(0, 1);
    let sum = 0;

    for(let i=0;i<nums.length;i++){
        sum+=nums[i];

        let remainder = sum%k;

        if(remainder < 0)
        remainder+=k;

        if(hashmap.has(remainder)){
            let n = hashmap.get(remainder);
            count+=n;
            hashmap.set(remainder, hashmap.get(remainder)+1);
        }

        else{
            hashmap.set(remainder, 1);
        }

    }

    return count;
};