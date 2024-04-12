/**
 * @param {number[]} height
 * @return {number}
 */
var trap = function(height) {
    let left_max = new Array(height.length);
    let right_max = new Array(height.length);

    let count = 0;

    left_max[0] = height[0];
    for(let i=1;i<height.length;i++){
        left_max[i] = Math.max(left_max[i-1], height[i]);
    }

    right_max[height.length-1] = height[height.length-1];

    for(let i=height.length-2;i>=0;i--){
        right_max[i] = Math.max(right_max[i+1], height[i]);
    }

    for(let i=0;i<height.length;i++){
        count+=Math.min(left_max[i], right_max[i])-height[i];
    }

    return count;

};