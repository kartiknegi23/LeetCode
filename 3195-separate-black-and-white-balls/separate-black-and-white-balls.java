class Solution {
    public long minimumSteps(String s) {
        long swap = 0;
        int count_black = 0;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1')
            count_black++;

            if(s.charAt(i)=='0')
            swap+=count_black;
        }

        return swap;
    }
}