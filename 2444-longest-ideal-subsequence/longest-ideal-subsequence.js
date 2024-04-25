/**
 * @param {string} s
 * @param {number} k
 * @return {number}
 */
function longestIdealString(s, k){
    let dp = new Array(27).fill(0);
    let n = s.length;

    for (let i = n - 1; i >= 0; i--) {
        let cc = s.charAt(i);
        let idx = cc.charCodeAt(0) - 'a'.charCodeAt(0);
        let maxi = Number.MIN_SAFE_INTEGER;

        let left = Math.max((idx - k), 0);
        let right = Math.min((idx + k), 26);

        for (let j = left; j <= right; j++) {
            maxi = Math.max(maxi, dp[j]);
        }

        dp[idx] = maxi + 1;
    }

    let max = Number.MIN_SAFE_INTEGER;
    for (let i = 0; i < 27; i++) {
        if (dp[i] > max)
            max = dp[i];
    }

    return max;
};