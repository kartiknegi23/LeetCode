class Solution {
    public int candy(int[] ratings) {
        int[]left = new int[ratings.length];
        int[]right = new int[ratings.length];

        left[0]=1;
        int candies=1;
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]){
                candies++;
                left[i]=candies;
            }

            else{
                candies=1;
                left[i]=candies;
            }
        }

        right[right.length-1]=1;
        candies=1;
        for(int i=right.length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                candies++;
                right[i]=candies;
            }

            else{
                candies=1;
                right[i]=candies;
            }
        }

        int result = 0;

        for(int i=0;i<ratings.length;i++){
            result+= Math.max(left[i], right[i]);
        }

        return result;
    }
}