/**
 * @param {string} s
 * @param {string[]} wordDict
 * @return {string[]}
 */
var wordBreak = function(s, wordDict) {
    let ans = [];
    let str = "";

    function sub(s,wordDict,i,str){
        if(i>=s.length)
        {
            let flag = true;
            let arr = str.split(" ");
            for(let j=0;j<arr.length;j++){
                if(!(wordDict.includes(arr[j]))){

                    flag = false;
                    break;
                }
            }
            if(flag===true)
            ans.push(str);

            return;
        }

        str+=s[i];

        sub(s,wordDict,i+1,str); /// Not Pick //

        
        str+=" ";
        sub(s,wordDict,i+1,str); // Pick //

    }

    sub(s,wordDict,0,str);

    return ans;
};