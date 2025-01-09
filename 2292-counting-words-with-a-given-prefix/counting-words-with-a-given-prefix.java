class Solution {
    public int prefixCount(String[] words, String pref) {
        int count = 0;
        for(int i=0;i<words.length;i++){
            int l = 0;
            int r = 0;
            if(pref.length() > words[i].length())
            continue;
            boolean isvalid = true; 
            while(l<words[i].length() && r<pref.length()){
                if(words[i].charAt(l) != pref.charAt(r)){
                    isvalid = false;
                    break;
                }
                l++;
                r++;
            }
            if(isvalid==true)
            count++;
        }
        return count;
    }
}