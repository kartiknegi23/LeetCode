/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 */
var nextGreaterElement = function(nums1, nums2) {
    let stack = [];
    let arr = new Array(nums2.length);
    let ans = [];
    let hashmap = new Map();

    for(let i=nums2.length-1;i>=0;i--){
        if(stack.length===0)
        {
            stack.push(nums2[i]);
            arr[i] = -1;
            hashmap.set(nums2[i], arr[i]);
            continue;
        }

        while(nums2[i] > stack[stack.length-1] && stack.length>0){
            stack.pop();
        }

        if(stack.length===0)
        {
            arr[i] = -1;
            stack.push(nums2[i]);
            hashmap.set(nums2[i], arr[i]);
            continue;
        }

        arr[i] = stack[stack.length-1];
        hashmap.set(nums2[i], arr[i]);
        stack.push(nums2[i]);
        
        
    }

    for(let i=0;i<nums1.length;i++){
        ans.push(hashmap.get(nums1[i]));
    }

    return ans;
};