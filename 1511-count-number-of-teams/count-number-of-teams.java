class Solution {
    public int numTeams(int[] rating) {
        int count = 0;
        for(int i=0;i<rating.length;i++){
            for(int j=i+1;j<rating.length;j++){
                if(rating[i]>rating[j])
                for(int k=j+1;k<rating.length;k++){
                    if(rating[j]>rating[k])
                    count++;
                }

                if(rating[i]<rating[j])
                for(int k=j+1;k<rating.length;k++){
                    if(rating[j]<rating[k])
                    count++;
                }
            }
        }
        return count;
    }
}