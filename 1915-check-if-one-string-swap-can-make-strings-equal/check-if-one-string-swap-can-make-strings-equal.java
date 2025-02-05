class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.equals(s2))
        return true;

        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for(int i=0;i<s1.length();i++){
            arr1[s1.charAt(i)-'a']++;
        }

        for(int i=0;i<s2.length();i++){
            arr2[s2.charAt(i)-'a']++;
        }

        for(int i=0;i<26;i++){
            if(arr1[i] != arr2[i])
            return false;
        }
        
        int i=0;
        int j=0;
        int count = 0;
        
        while(i<s1.length() && j<s2.length()){
            if(s1.charAt(i) != s2.charAt(j))
            count++;

            if(count>2)
            return false;

            i++;
            j++;
        }
        return true;
    }
}