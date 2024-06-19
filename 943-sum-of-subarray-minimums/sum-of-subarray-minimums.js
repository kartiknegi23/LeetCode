/**
 * @param {number[]} arr
 * @return {number}
 */
var sumSubarrayMins = function(arr) {
    let left_minimum_element = new Array(arr.length);
    let right_minimum_element = new Array(arr.length);
    let stack_left=[];
    let stack_right = [];
    let MOD = 1000000007;

    for(let i=0;i<left_minimum_element.length;i++){
        while(stack_left.length>0 && arr[i]<=arr[stack_left[stack_left.length-1]]){
            stack_left.pop();
        }
        if(stack_left.length===0)
        left_minimum_element[i]=-1;

        else
        left_minimum_element[i]=stack_left[stack_left.length-1];

        stack_left.push(i);
    }


    for(let i=right_minimum_element.length-1;i>=0;i--){
        while(stack_right.length>0 && arr[i]<arr[stack_right[stack_right.length-1]]){
            stack_right.pop();
        }
        if(stack_right.length===0)
        right_minimum_element[i]=right_minimum_element.length;

        else
        right_minimum_element[i]=stack_right[stack_right.length-1];

        stack_right.push(i);
    }


    let sum =0;
    for(let i=0;i<arr.length;i++){
        let left_sum = i-left_minimum_element[i];
        let right_sum = right_minimum_element[i] - i;
        console.log(left_sum, right_sum);
        let product = left_sum*right_sum;
        let total = arr[i]*product;
        sum = (sum+total)%MOD;
    }

    return sum;
};