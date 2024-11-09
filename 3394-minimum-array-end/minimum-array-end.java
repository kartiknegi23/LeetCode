class Solution {
    public long minEnd(int n, int x) {
        long num = x;
        for(int count=1;count<n;count++){
            num = ((num+1)|x);
        }
        return num;
    }
}