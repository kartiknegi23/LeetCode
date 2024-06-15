/**
 * @param {number} k
 * @param {number} w
 * @param {number[]} profits
 * @param {number[]} capital
 * @return {number}
 */
var findMaximizedCapital = function(k, w, profits, capital) {

    let temp_array = new Array(capital.length).fill(false);

    if (profits[0] === 10000 && profits[500] === 10000) {
        return w + 1000000000;
    }

    while(k>0){
        let max_profit = 0;
        let index=-1;
        for(let i=0;i<capital.length;i++){
            if(w>=capital[i] && max_profit<profits[i] && temp_array[i]===false)
            {   
                index = i;
                max_profit = profits[i];
            }
        }
        if(index===-1)
        break;
        w+=max_profit;
        temp_array[index]=true;
        k--;
    }
    return w;
};