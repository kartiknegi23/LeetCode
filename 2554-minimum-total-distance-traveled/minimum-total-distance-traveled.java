class Solution {
    public long solve(int i, int j, List<Integer> robot, List<Integer> list, long[][] dp){
        if(i>=robot.size())
        return 0;

        if(j>=list.size())
        return Long.MAX_VALUE/2;

        if(dp[i][j]!=-1)
        return dp[i][j];

        long pick = 0;
        //pick//
        pick = Math.abs(list.get(j)-robot.get(i)) + solve(i+1, j+1, robot, list, dp);

        //skip//
        long skip = solve(i,j+1,robot,list, dp);

        return dp[i][j] = Math.min(pick,skip);
    }

    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        List<Integer>list = new ArrayList<>();
        for(int i=0;i<factory.length;i++){
            int num = factory[i][1];
            while(num>0){
                list.add(factory[i][0]);
                num--;
            }
        }
        Collections.sort(list);

        long[][] dp = new long[robot.size()][list.size()];
        for(long[] arr : dp){
            Arrays.fill(arr, -1);
        }

        return solve(0, 0, robot, list, dp);
    }
}