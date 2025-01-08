class Solution {
    public boolean isPrefixAndSuffix(String str1, String str2){
        if(str1.length() > str2.length())
        return false;

        //prefix//
        int l = 0;
        int r = 0;
        boolean isvalid = true;

        while(l<str1.length() && r<str2.length()){
            if(str1.charAt(l) != str2.charAt(r)){
                isvalid = false;
                break;
            }
            l++;
            r++;
        }
        if(isvalid==false)
        return false;

        //suffix//
        int len = Math.min(str1.length(), str2.length());
        int ind = Math.max(str1.length(), str2.length()) - len;

        l = 0;
        r = ind;

        while(l<str1.length() && r<str2.length()){
            if(str1.charAt(l) != str2.charAt(r)){
                isvalid = false;
                break;
            }
            l++;
            r++;
        }
        
        return isvalid;
    }

    public int countPrefixSuffixPairs(String[] words) {
        int result = 0;
        for(int i=0;i<words.length;i++){
            for(int j=i+1;j<words.length;j++){
                if(isPrefixAndSuffix(words[i], words[j]) == true)
                result++;
            }
        }
        return result;
    }
}