class Solution {
    public boolean compare(String s1, String s2){
        if(s1.length() != s2.length()+1)
        return false;
        
        int i=0;
        int j=0;

        while(i<s1.length()){

            if(j<s2.length() && s1.charAt(i) == s2.charAt(j)){
                i++;
                j++;
            }
            else{
                i++;
            }
        }

        if(i==s1.length() && j==s2.length())
        return true;
        else
        return false;
    } 

    public int longestStrChain(String[] words) {
        int[] lsc = new int[words.length];
        Arrays.fill(lsc, 1);
        Arrays.sort(words, (a,b)->{
            return a.length()-b.length();
        });
        int length = 1;

        for(int i=1;i<words.length;i++){
            for(int j=0;j<i;j++){
                if(compare(words[i], words[j]) ){
                    lsc[i] = Math.max(lsc[i], lsc[j]+1);
                    length = Math.max(length, lsc[j]+1);
                }
            }
        }

        System.out.println(Arrays.toString(lsc));
        return length;
    }
}