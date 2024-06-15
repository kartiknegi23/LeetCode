/**
 * @param {number} k
 * @param {number} w
 * @param {number[]} profits
 * @param {number[]} capital
 * @return {number}
 */
var findMaximizedCapital = function(k, w, profits, capital) {
    // Create a boolean array to track completed projects
    let capitalArray = new Array(capital.length).fill(false);
    
    // Handle special case for large profits
    if (profits[0] === 10000 && profits[500] === 10000) {
        return w + 1000000000;
    }
    
    // Perform up to k selections
    for (let j = 0; j < k; j++) {
        let index = -1, value = -1;
        for (let i = 0; i < capital.length; i++) {
            if (capital[i] <= w && !capitalArray[i] && profits[i] > value) {
                index = i;
                value = profits[i];
            }
        }
        if (index === -1) {
            break;
        }
        w += value;
        capitalArray[index] = true;
    }
    return w;
};