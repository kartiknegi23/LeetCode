class Solution {
    public int largestCombination(int[] candidates) {
        int[] count = new int[24];
        for(int i=0;i<24;i++){
            for(int j=0;j<candidates.length;j++){
                count[i] = count[i] + candidates[j]%2;
                candidates[j]/=2;
            }
        }

        int max = 0;
        for(int i=0;i<count.length;i++){
            max = Math.max(max, count[i]);
        }
        return max;
    }
}