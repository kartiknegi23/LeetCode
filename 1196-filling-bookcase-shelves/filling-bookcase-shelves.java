class Solution {
    int WIDTH;
    int[][] dp = new int[1000][1001];

    public int solve(int[][] books, int i, int remaining, int maxheight){
        if(i>=books.length){
            return maxheight;
        }

        if(dp[i][remaining]!=-1)
        return dp[i][remaining];

        int height = books[i][1];
        int width = books[i][0];

        int keep = Integer.MAX_VALUE;
        int skip = Integer.MIN_VALUE;

        //Keep//
        if(width<=remaining){
            keep = solve(books, i+1, remaining-width, Math.max(maxheight, height));
        }

        //Skip//
        skip = maxheight + solve(books, i+1, WIDTH-width, height);

        return dp[i][remaining]=Math.min(keep,skip);

    }

    public int minHeightShelves(int[][] books, int shelfWidth) {
        for (int i = 0; i < 1000; i++) {
            Arrays.fill(dp[i], -1);
        }

        WIDTH = shelfWidth;
        return solve(books, 0, shelfWidth, 0);
    }
}