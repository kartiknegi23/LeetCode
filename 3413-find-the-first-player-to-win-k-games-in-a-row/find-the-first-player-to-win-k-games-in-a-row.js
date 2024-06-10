/**
 * @param {number[]} skills
 * @param {number} k
 * @return {number}
 */
var findWinningPlayer = function(skills, k) {
    if(k>=(skills.length-1)){
        let max = -Infinity;
        for(let i=0;i<skills.length;i++){
            max = Math.max(max, skills[i]);
        }

        return skills.indexOf(max);
    }

    let max_count = 0;
    let max_index = 0;
    for(let i=1;i<skills.length;i++){
        if(skills[max_index]>skills[i]){
            max_count++;
        }

        else{
            max_count=1;
            max_index=i;
        }

        if(max_count===k)
        return max_index;
    }

    return max_index;
};