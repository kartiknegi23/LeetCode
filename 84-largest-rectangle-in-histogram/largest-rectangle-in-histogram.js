/**
 * @param {number[]} heights
 * @return {number}
 */
var largestRectangleArea = function(heights) {
    let stack = [];
    heights.push(0);
    let max = 0;

    for(let i=0;i<heights.length;i++){
        let heightstart = i;
        while(stack.length && stack[stack.length-1][1] > heights[i]){
            let [pos, height] = stack.pop();
            max = Math.max(max, (i-pos)*height);
            heightstart = pos;
        }
        stack.push([heightstart, heights[i]]);
    }

    return max;
};