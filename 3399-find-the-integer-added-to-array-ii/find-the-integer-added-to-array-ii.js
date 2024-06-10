/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var minimumAddedInteger = function (nums1, nums2) {
    let min = Infinity;
    nums1.sort((a, b) => a - b);
    nums2.sort((a, b) => a - b);

    console.log(nums1, nums2);

    for (let i = 0; i < Math.min(3, nums1.length); i++) {

        let diff = nums2[0] - nums1[i];
        let limit = 0;
        let index = 0;
        let flag = true;

        for (let j = 0; j < nums1.length; j++) {

            if (diff !== (nums2[index] - nums1[j]))
                limit++;

            else
            index++;;

            if (limit > 2) {
                flag = false;
                break;
            }

            
        }

        if (flag === true)
            min = Math.min(min, diff);

    }

    return min;
};