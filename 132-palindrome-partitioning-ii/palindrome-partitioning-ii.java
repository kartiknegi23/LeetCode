class Solution {
    public boolean isPalindrome(int i, int j, String s){

        while(i<j){
            if(s.charAt(i) != s.charAt(j))
            return false;
            i++;
            j--;
        }
        return true;
    }

    public int solve(int i, int j, String s, int[] dp){
        if(i>j)
        return 0;

        if(dp[i]!=-1)
        return dp[i];

        int min = Integer.MAX_VALUE;
        for(int index=i;index<=j;index++){
            if(isPalindrome(i,index,s)){
                int count = 1 + solve(index+1,j,s, dp);
                min = Math.min(min, count);
            }
            
        }
        return dp[i] = min;
    }

    public int minCut(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);

        return solve(0, s.length()-1, s, dp)-1;
    }
}