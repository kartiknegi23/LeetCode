/**
 * @param {string[]} words
 * @param {character[]} letters
 * @param {number[]} score
 * @return {number}
 */
var maxScoreWords = function(words, letters, score) {
    let max = 0;
    let point = 0;

    let hashmap = new Map();

    for(let i=0;i<letters.length;i++){
        if(hashmap.has(letters[i]))
        hashmap.set(letters[i] ,hashmap.get(letters[i])+1);

        else
        hashmap.set(letters[i], 1);
    }


    function calc(i,point,hashmap){
        if(i>=words.length){
            max = Math.max(max,point);
            return;
        }

        let tempmap = new Map(hashmap);
        calc(i+1,point, tempmap); //Not to PIck //

        
        let temp = point;
        for(let j=0;j<words[i].length;j++){
            if(hashmap.has(words[i][j]) && hashmap.get(words[i][j])>0){

                hashmap.set(words[i][j], hashmap.get(words[i][j])-1);
                let index = words[i].charCodeAt(j)-'a'.charCodeAt(0);
                point+=score[index];
            }
            else{
                point = temp;
                break;
            }
        }    
        calc(i+1,point,hashmap);   // PIck //


         



    }

    calc(0,0, hashmap);


    return max;
};