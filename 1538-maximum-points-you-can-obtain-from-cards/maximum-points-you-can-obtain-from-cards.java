class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int result = 0;
        int low=0;
        int total_sum=0;
        int high=cardPoints.length-k-1;

        for(int i=0;i<cardPoints.length;i++){
            total_sum+=cardPoints[i];
        }
        
        int sum=0;
        for(int i=low;i<=high;i++){
                sum+=cardPoints[i];
        }
        result = Math.max(result, total_sum-sum);

        while(high<cardPoints.length-1){
            sum-=cardPoints[low];
            low++;
            high++;
            sum+=cardPoints[high];
            result = Math.max(result, total_sum-sum);
        }
        
        return result;

    }
}