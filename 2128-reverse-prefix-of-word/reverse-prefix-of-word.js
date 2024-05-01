/**
 * @param {string} word
 * @param {character} ch
 * @return {string}
 */
var reversePrefix = function(word, ch) {
    let index = -1;
    for(let i=0;i<word.length;i++){
        if(ch==word[i])
        {index=i
        break;}
    }

    if(index===-1)
    return word;

    let ans = "";

    for(let i=index;i>=0;i--){
        ans+=word[i];
    }

    for(let i=index+1;i<word.length;i++){
        ans+=word[i];
    }

    return ans;
};