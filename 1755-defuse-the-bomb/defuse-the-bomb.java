class Solution {
    public int[] decrypt(int[] code, int k) {
        int count = 0;
        int n = code.length;
        int[] ans = new int[code.length];

        if(k==0)
        return ans;

        for(int i=0;i<code.length;i++){
            if(k>0)
            {   
                int sum=0;
                count = k;
                int idx = i+1;
                while(count>0){
                    sum+=code[idx%n];
                    idx++;
                    count--;
                }
                ans[i]=sum;
            }
            else if(k<0)
            {
                int sum=0;
                count = -k;
                int idx = (i-1+n)%n;                
                while(count>0){
                    sum+=code[idx%n];
                    idx = (idx-1+n)%n;
                    count--;
                }
                ans[i]=sum;
            }
        }

        return ans;
    }
}