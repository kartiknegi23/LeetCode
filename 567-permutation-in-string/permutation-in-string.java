class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if(n>m)
        return false;

        Map<Character, Integer>hashmap1 = new HashMap<>();
        Map<Character, Integer>hashmap2 = new HashMap<>();

        for(int i=0;i<s1.length();i++){
            hashmap1.put(s1.charAt(i), hashmap1.getOrDefault(s1.charAt(i), 0)+1);
        }

        int i=0;
        int j=0;
        while(j<m){
            hashmap2.put(s2.charAt(j), hashmap2.getOrDefault(s2.charAt(j), 0)+1);
            
            if((j-i+1) > n){
                hashmap2.put(s2.charAt(i), hashmap2.get(s2.charAt(i))-1);
                if(hashmap2.get(s2.charAt(i))==0)
                hashmap2.remove(s2.charAt(i));
                i++;
            }

            if(hashmap2.equals(hashmap1))
            return true;

            j++;
        }

        return false;
    }
}