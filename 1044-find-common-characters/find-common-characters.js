/**
 * @param {string[]} words
 * @return {string[]}
 */

function fill(words, array){
    for(let i=0;i<words.length;i++){
        let index = words[i].charCodeAt(0)-'a'.charCodeAt(0);
        array[index]++;
    }
}

var commonChars = function(words) {
    let count = new Array(26).fill(0);

    fill(words[0], count);   

    for(let i=1;i<words.length;i++){
        let temp = new Array(26).fill(0);
        fill(words[i], temp);

        for(let j=0;j<26;j++){
            count[j] = Math.min(count[j], temp[j]);
        }
    }

    let arr = [];

    for(let i=0;i<26;i++){
        while(count[i]>0){
            let char = String.fromCharCode(i+'a'.charCodeAt(0));
            arr.push(char);
            count[i]--;
        }
    }

    return arr;
};