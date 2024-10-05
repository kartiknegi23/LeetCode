class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if(n>m)
        return false;

        int[] map1 = new int[26];
        int[] map2 = new int[26];

        for(int i=0;i<s1.length();i++){
            map1[s1.charAt(i)-'a']++;
        }

        int i=0;
        int j=0;
        while(j<m){
            map2[s2.charAt(j)-'a']++;
            
            if((j-i+1) > n){
                map2[s2.charAt(i)-'a']--;
                i++;
            }

            if(Arrays.equals(map1, map2))
            return true;

            j++;
        }

        return false;
    }
}