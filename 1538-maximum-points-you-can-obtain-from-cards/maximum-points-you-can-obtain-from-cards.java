class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int result = 0;
        int low=0;
        int total_sum=0;
        int high=cardPoints.length-k-1;

        for(int i=0;i<cardPoints.length;i++){
            total_sum+=cardPoints[i];
        }

        while(high<cardPoints.length){
            int sum=0;
            for(int i=low;i<=high;i++){
                sum+=cardPoints[i];
            }
            result = Math.max(result, total_sum-sum);
            high++;
            low++;
        }
        
        return result;

    }
}