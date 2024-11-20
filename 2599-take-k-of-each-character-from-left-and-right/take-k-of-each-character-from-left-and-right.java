class Solution {
    public int takeCharacters(String s, int k) {
        int[] count = new int[3];
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
        }
        if(count[0]<k || count[1]<k || count[2]<k)
        return -1;

        int left = 0;
        int right = 0;
        int ans = Integer.MIN_VALUE;

        while(right<s.length()){
            count[s.charAt(right)-'a']--;
            
            while(left<=right && count[s.charAt(right)-'a']<k){
                count[s.charAt(left)-'a']++;
                left++;
            }

            ans = Math.max(ans, right-left+1);

            right++;
        }

        return ans == Integer.MAX_VALUE ? -1 : s.length()-ans;
    }
}