/**
 * @param {string} s
 * @return {string[][]}
 */

function check(str){
    let left = 0;
    let right = str.length-1;


    while(left<right){
        if(str[left]!=str[right])
        return false;
        left++;
        right--;
    }

    return true;
}

var partition = function(s) {
    let ans = [];
    let arr = [];

    function sub(i){
        if(i>=s.length)
        {
            ans.push([...arr]);
            return;
        }

        for(let start = i;start<s.length;start++){
            let str = s.slice(i,start+1);

            if(check(str)===true){
                arr.push(str);
                sub(start+1);
                arr.pop();
            }
        }
    }

    sub(0);

    return ans;
};