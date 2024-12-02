class Solution {
    public boolean check(String str, String searchWord){
        int i=0;
        int j=0;

        if(str.length() < searchWord.length())
        return false;

        while(i<searchWord.length() && j<searchWord.length()){
            if(str.charAt(i) != searchWord.charAt(j))
            return false;

            i++;
            j++;
        }
        return true;
    }

    public int isPrefixOfWord(String sentence, String searchWord) {

        String[] arr = sentence.split(" ");
        for(int i=0;i<arr.length;i++){
            boolean result = check(arr[i], searchWord);
            if(result==true)
            return i+1;
        }

        return -1;
    }
}