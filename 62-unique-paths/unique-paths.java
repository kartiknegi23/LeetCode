class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];

        for(int i=0;i<m;i++){
            int[] temp = new int[n];
            for(int j=0;j<n;j++){

                int up = 0;
                int left = 0;

                if(i==0 && j==0)
                temp[j]=1;

                else{
                    if(j>0)
                    left = temp[j-1];

                    if(i>0)
                    up = dp[j];

                    temp[j] = left + up;
                }
            }
            dp = temp;
        }
        
        return dp[n-1];
    }
}