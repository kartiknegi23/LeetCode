/**
 * @param {number[]} heights
 * @return {number}
 */
var largestRectangleArea = function(heights) {
    let stack = [];
    let area = 0;
    heights.push(0);

    for(let i=0;i<heights.length;i++){
        let heightstart = i;
        while(stack.length && stack[stack.length-1][0]>heights[i]){
            let [height, index] = stack.pop();
            area = Math.max(area, height*(i-index));
            heightstart = index;
        }
        stack.push([heights[i], heightstart]);
    }

    console.log(stack, stack[stack.length-1]);

    return area;
};