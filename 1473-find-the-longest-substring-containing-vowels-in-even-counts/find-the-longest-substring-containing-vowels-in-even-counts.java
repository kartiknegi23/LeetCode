class Solution {
    public int findTheLongestSubstring(String s) {
        HashMap<String, Integer>hashmap = new HashMap<>();
        int result = 0;
        String current = "00000";
        hashmap.put(current, -1);
        int[] vowel = new int[5];

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='a'){
                vowel[0] = vowel[0] ^ 1;
            }
            else if(s.charAt(i)=='e'){
                vowel[1] = vowel[1] ^1;
            }
            else if(s.charAt(i)=='i'){
                vowel[2] = vowel[2] ^1;
            }
            else if(s.charAt(i)=='o'){
                vowel[3] = vowel[3] ^1;
            }
            else if(s.charAt(i)=='u'){
                vowel[4] = vowel[4] ^1;
            }

            current = "";
            for(int j=0;j<5;j++){
                current = current + (char) (vowel[j] + '0'); 
            }

            if(hashmap.containsKey(current)){
                result = Math.max(result, i - hashmap.get(current));
            }
            else
            hashmap.put(current, i);
        }

        return result;
    }
}