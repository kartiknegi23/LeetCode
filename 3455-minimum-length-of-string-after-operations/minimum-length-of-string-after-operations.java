class Solution {
    public int minimumLength(String s) {
        int n = s.length();
        if(n<3)
        return n;
        
        int[] count = new int[26];
        
        
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
        }

        int remove = 0;
        for(int i=0;i<26;i++){
            if(count[i]>=3){
                if(count[i]%2==0)
                remove+=(count[i]-2);

                else
                remove+=(count[i]-1);
            }
        }
        return n-remove;
    }
}