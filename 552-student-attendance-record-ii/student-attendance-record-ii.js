var checkRecord = function(n) {
    const MOD = 1e9 + 7;
    
    // Initialize dp table
    let dp = Array.from({ length: n + 1 }, () =>
        Array.from({ length: 2 }, () =>
            Array(3).fill(0)
        )
    );
    
    // Base case: 1 way to have 0 length sequence
    dp[0][0][0] = 1;
    
    // Fill the dp table
    for (let i = 1; i <= n; i++) {
        for (let j = 0; j <= 1; j++) {
            for (let k = 0; k <= 2; k++) {
                // Add 'P'
                dp[i][j][0] = (dp[i][j][0] + dp[i - 1][j][k]) % MOD;
                // Add 'A'
                if (j > 0) {
                    dp[i][j][0] = (dp[i][j][0] + dp[i - 1][j - 1][k]) % MOD;
                }
                // Add 'L'
                if (k > 0) {
                    dp[i][j][k] = (dp[i][j][k] + dp[i - 1][j][k - 1]) % MOD;
                }
            }
        }
    }
    
    // Sum all valid states of length n
    let result = 0;
    for (let j = 0; j <= 1; j++) {
        for (let k = 0; k <= 2; k++) {
            result = (result + dp[n][j][k]) % MOD;
        }
    }
    
    return result;
};
