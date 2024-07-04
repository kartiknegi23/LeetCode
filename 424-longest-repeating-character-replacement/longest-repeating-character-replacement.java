class Solution {
    public int characterReplacement(String s, int k) {
        int result = 0;
        int low=0;
        int high = 0;
        int[] map = new int[26];
        int max_frequency = 0;

        while(high<s.length()){
            map[s.charAt(high)-'A']++;
            max_frequency = Math.max(max_frequency, map[s.charAt(high)-'A']);
            int change = (high-low+1) - max_frequency;

            while(change>k){
                map[s.charAt(low)-'A']--;
                max_frequency = 0;
                for(int i=0;i<26;i++){
                    max_frequency = Math.max(max_frequency, map[i]);
                }
                low++;
                change = (high-low+1) - max_frequency;
            }

            if(change<=k){
                result = Math.max(result, high-low+1);
            }
            high++;
        }   

        return result;
    }
}