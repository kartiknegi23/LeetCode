/**
 * @param {number[]} score
 * @return {string[]}
 */
var findRelativeRanks = function(score) {
    let max = -Infinity;
    let ans = new Array(score.length).fill(0);
    let temp = new Array(score.length).fill(0);
    let hashmap = new Map();
    
    for(let i=0;i<temp.length;i++){
        temp[i]=score[i];
    }


    temp.sort((a,b)=>b-a);

    for(let i=0;i<temp.length;i++){
        if(i==0){
            hashmap.set(temp[i], "Gold Medal");
        }

        else if(i==1){
            hashmap.set(temp[i], "Silver Medal");
        }

        else if(i==2){
            hashmap.set(temp[i], "Bronze Medal");
        }

        else{
            hashmap.set(temp[i], i+1);
        }
    }


    for(let i=0;i<ans.length;i++){
        ans[i] = hashmap.get(score[i]);
        ans[i]=ans[i].toString();
    }

    return ans;
};