/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 */
var nextGreaterElement = function(nums1, nums2) {
    let arr = [];

    for(let i=0;i<nums1.length;i++){
        let ele = nums1[i];
        let index = nums2.indexOf(ele);
        let max = ele;
        for(let j=index+1;j<nums2.length;j++){
            max = Math.max(max, nums2[j]);
            if(max>ele){
                arr.push(max);
                break;
            }
        }
        if(max===ele)
        arr.push(-1);
    }

    return arr;
};