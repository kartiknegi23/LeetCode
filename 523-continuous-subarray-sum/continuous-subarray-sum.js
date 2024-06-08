/**
 * @param {number[]} nums
 * @param {number} k
 * @return {boolean}
 */
var checkSubarraySum = function(nums, k) {
    if(nums.length===1)
    return false;

    let prefix = [];
    let sum = 0;

    let zcount = 0;
    for(let i=0;i<nums.length;i++){
        if(nums[i]===0)
        zcount++;

        else
        zcount=0;

        if(zcount===2)
        return true;
    }


    for(let i=0;i<nums.length;i++){
        prefix[i]= nums[i]+sum;
        sum = prefix[i];
    }

    console.log(prefix);

    let hashmap = new Map();

    for(let i=0;i<prefix.length;i++){
        prefix[i] = prefix[i]%k;

        if((hashmap.has(prefix[i]) && (hashmap.get(prefix[i])!== i-1)) || (prefix[i]===0 && i!==0))
        return true;

        else
        {
            if(hashmap.has(prefix[i]))
            continue;

            else
            hashmap.set(prefix[i], i);
        }
        
    }

    console.log(prefix);

    return false;
};