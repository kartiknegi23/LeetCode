class Solution {
    public String compressedString(String word) {
        StringBuilder comp = new StringBuilder();
        int count = 1;

        for(int i=1;i<word.length();i++){
            if(word.charAt(i) == word.charAt(i-1) && count<9){
                count++;
            }
            else if(word.charAt(i) == word.charAt(i-1) && count==9){
                comp.append(count);
                comp.append(word.charAt(i));
                count=1;
            }
            else{
                comp.append(count);
                comp.append(word.charAt(i-1));
                count = 1;
            }
        }
        comp.append(count);
        comp.append(word.charAt(word.length()-1));

        return comp.toString();
    }
}