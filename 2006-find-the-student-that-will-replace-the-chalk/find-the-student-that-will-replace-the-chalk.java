class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int index=0;
        int n=chalk.length;

        int sum=0;
        for(int i=0;i<n;i++){
            sum+=chalk[i];
        }

        if(sum>k)
        sum = sum-k;

        while(k >= chalk[index]){
            k-=chalk[index];
            index++;

            if(index==n)
            index=0;
        }

        return index;
    }
}