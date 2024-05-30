/**
 * @param {string} s
 * @return {string}
 */
var longestPalindrome = function(s) {
    let str = "";
    let low = 0;
    let count = 0;

    for(let i=0;i<s.length;i++){
        for(let j=i;j<s.length;j++){
            let left = i;
            let right = j;
            let flag = true;

            while(left<=right){
                if(s[left]!==s[right]){
                    flag = false;
                    break;
                }

                left++;
                right--;
            }
            if(flag===true){
                let temp = j-i+1;
                if(temp>count){
                    count = temp;
                    str = "";
                    for(let k=i;k<=j;k++){
                        str+=s[k];
                    }
                }
            }
        }


    }

    return str;
    
};