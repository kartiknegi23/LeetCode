class Solution {
    public int getLucky(String s, int k) {
        int n=0;

        for(int i=0;i<s.length();i++){
            int num = (s.charAt(i)-'a')+1;
            while(num>0){
                n = n + num%10;
                num/=10;
            }
        }
        k-=1;
       
        while(k>0){
            int result = 0;
            while(n>0){
                result = result + n%10;
                n/=10;
            }
            n=result;
            k--;
        }

        return n;
    }
}