class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int index=0;
        int n=chalk.length;

        long sum=0;
        for(int i=0;i<n;i++){
            sum+=chalk[i];
        }

        k = (int) (k % sum);


        while(k >= chalk[index]){
            k-=chalk[index];
            index++;

            if(index==n)
            index=0;
        }

        return index;
    }
}