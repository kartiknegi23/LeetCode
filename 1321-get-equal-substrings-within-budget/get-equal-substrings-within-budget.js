/**
 * @param {string} s
 * @param {string} t
 * @param {number} maxCost
 * @return {number}
 */
var equalSubstring = function(s, t, maxCost) {
    let cost = 0;
    let count = 0;
    let ans = 0;
    let start = 0;

    for(let end = 0;end<s.length;end++){
        cost += Math.abs(s.charCodeAt(end)-t.charCodeAt(end));
        count++;

        while(cost>maxCost){
            cost -= Math.abs(s.charCodeAt(start)-t.charCodeAt(start));
            start++;
            count--;
        }

        ans = Math.max(ans,count);
    }

    return ans;
};