class Solution {
    public int numberOfSubstrings(String s) {
        int[] count = new int[3];
        int low=0;
        int high=0;
        int result=0;

        while(high<s.length()){
            count[s.charAt(high)-'a']++;

            while(count[0]>0 && count[1]>0 && count[2]>0){
                result+= (s.length()-(high+1)+1);
                count[s.charAt(low)-'a']--;
                low++;
            }

            high++;
        }

        return result;

    }
}