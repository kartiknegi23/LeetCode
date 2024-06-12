/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var sortColors = function (nums) {
    let hashmap = new Map();

    for (let i = 0; i < nums.length; i++) {
        if (hashmap.has(nums[i]))
            hashmap.set(nums[i], hashmap.get(nums[i]) + 1);

        else
            hashmap.set(nums[i], 1);
    }

    let index = 0;
    let count = 0;

    while (count < 3) {
        while (hashmap.has(count)) {
            nums[index] = count;
            hashmap.set(count, hashmap.get(count) - 1);
            index++;
            if (hashmap.get(count) === 0) {
                hashmap.delete(count);
                count++;
            }
        }
        count++;
    }
    return nums;
};