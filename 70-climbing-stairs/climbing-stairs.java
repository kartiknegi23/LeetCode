class Solution {
    public int calculate(int n, int pos, int count, int[] dp){
        if(pos==n)
        return 1;

        if(pos>n)
        return 0;

        if(dp[pos]!=-1)
        return dp[pos];

        //ONe step//
        int one = calculate(n, pos+1, count, dp);

        //Two Steps//
        int two = calculate(n, pos+2, count, dp);

        return dp[pos] = one+two;
    }

    public int climbStairs(int n) {
        int count = 0;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        return calculate(n, 0, count, dp);
    }
}