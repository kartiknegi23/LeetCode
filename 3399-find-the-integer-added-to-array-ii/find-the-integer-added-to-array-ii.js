/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var minimumAddedInteger = function(nums1, nums2) {
    nums1.sort((a,b)=>a-b);
    nums2.sort((a,b)=>a-b);

    let ans = Infinity;

    for(let i=0;i<nums1.length;i++){
        for(let j=i+1;j<nums1.length;j++){
            let nums3 = [];
            for(let k=0;k<nums1.length;k++){
                if(k!==i && k!==j){
                    nums3.push(nums1[k]);
                }
            }
            
            let diff = nums2[0]-nums3[0];

            for(let l=1;l<nums2.length;l++){
                if(diff!==(nums2[l]-nums3[l]))
                {   
                    diff = Infinity;
                    break;
                }
            }            
            
            ans = Math.min(ans, diff);

        }
    }
    return ans;
};