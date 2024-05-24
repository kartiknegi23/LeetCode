/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var findMedianSortedArrays = function(nums1, nums2) {
    for(let i=0;i<nums2.length;i++){
        nums1.push(nums2[i]);
    }

    nums1.sort((a,b)=>a-b);

    let mid = Math.floor((nums1.length-1)/2);
    console.log(nums1, mid);

    if(nums1.length%2===0){
        return (nums1[mid]+nums1[mid+1])/2;
    }

    else{
        return nums1[mid];
    }
};