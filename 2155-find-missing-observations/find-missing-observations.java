class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum=0;

        for(int i=0;i<rolls.length;i++){
            sum+=rolls[i];
        }

        int diff = mean*(n+rolls.length)-sum;

        if(diff<n || diff>6*n)
        return new int[0];

        int avg = diff/n;
        int remainder = diff%n;

        int[] arr = new int[n]; 
        for(int i=0;i<n;i++){
            arr[i] = avg;
            if(remainder>0){
                arr[i]++;
                remainder--;
            }
        }

        return arr;
    }
}