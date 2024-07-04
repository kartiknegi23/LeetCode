class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        int result = 0;
        int low = 0;
        int high = 0;

        while(high<s.length()){
            while(map.containsKey(s.charAt(high))){
                map.remove(s.charAt(low));
                low++;
            }


            map.put(s.charAt(high), 1);

            result = Math.max(result, high-low+1);
            high++;
        }

        return result;
    }
}