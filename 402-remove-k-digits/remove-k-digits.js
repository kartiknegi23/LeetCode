/**
 * @param {string} num
 * @param {number} k
 * @return {string}
 */
var removeKdigits = function(num, k) {
    let stack = [];
    let count = 0;
    for(let i=0;i<num.length;i++){
        while(stack.length>0 && count<k && num[i]<stack[stack.length-1]){
            stack.pop();
            count++;
        }

        stack.push(num[i]);
    }

    while(count<k){
        stack.pop();
        count++;
    }

    console.log(stack);

    let str = "";
    let flag = false;
    for(let i=0;i<stack.length;i++){
        if(stack[i]==="0" && flag===false)
        continue;

        if(stack[i]!=="0")
        {   
            flag = true;
        }
        
        str+=stack[i];

    }

    if(str.length>0)
    return str;

    else
    return "0";

};