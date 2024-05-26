/**
 * @param {string} word
 * @return {string}
 */
var compressedString = function(word) {
    let str = "";
    let stack = [];
    let count = 0;
    for(let i=0;i<word.length;i++){

        if(count===0 && i!==0){
            stack.push(word[i]);
        }
        
        if(i===0)
        {
            stack.push(word[i]);
            count++;
        }

        
        else{
            if(word[i]!==stack[stack.length-1]){
                str+=count;
                str+=stack[stack.length-1];
                count = 1;
                stack.pop();
                stack.push(word[i]);
            }

            else{
                count++;
                if(count===9)
                {
                str+=count;
                str+=stack[stack.length-1];
                count = 0;
                stack.pop();
                }
            }
        }
    }
    if(stack.length!=0)
    {str+=count;
    str+=stack[stack.length-1];}

    return str;
};