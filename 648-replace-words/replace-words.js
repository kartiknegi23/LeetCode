/**
 * @param {string[]} dictionary
 * @param {string} sentence
 * @return {string}
 */

function findroot(arr, dictionary){
    let temp = "";
    for(let i=0;i<arr.length;i++){
        temp += arr[i];
        for(let j=0;j<dictionary.length;j++){
            if(temp===dictionary[j]){
                return temp;
            }            
        }
    }
    return arr;
}

var replaceWords = function(dictionary, sentence) {
    let str = "";
    let arr = sentence.split(" ");

    for(let i=0;i<arr.length;i++){
        str += findroot(arr[i], dictionary);

        if(i<arr.length-1)
        str+=" ";
    }
    
    return str;
};