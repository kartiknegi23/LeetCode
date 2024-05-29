/**
 * @param {string} s
 * @return {number}
 */
var numSteps = function(s) {
    let count = 0;
    let num = BigInt(0);  // Initialize num as BigInt
    let ind = 0;

    // Convert the binary string to a BigInt
    for (let i = s.length - 1; i >= 0; i--) {
        num += BigInt(parseInt(s[i])) * (BigInt(2) ** BigInt(ind));
        ind++;
    }

    // Perform steps until num becomes 1
    while (num !== BigInt(1)) {
        if (num % BigInt(2) === BigInt(0)) {
            num /= BigInt(2);
        } else {
            num += BigInt(1);
        }
        count++;
    }

    return count;
};