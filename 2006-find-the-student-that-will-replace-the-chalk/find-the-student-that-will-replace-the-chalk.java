class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int index=0;
        int n=chalk.length;


        while(k >= chalk[index]){
            k-=chalk[index];
            index++;

            if(index==n)
            index=0;
        }

        return index;
    }
}