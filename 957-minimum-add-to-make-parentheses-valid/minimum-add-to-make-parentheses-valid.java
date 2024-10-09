class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character>stack = new Stack<>();
        int close = 0;
        int open = 0; 
        for(int i=0;i<s.length();i++){
            if(open>0  && s.charAt(i) == ')'){
                open--;
            }

            else if(s.charAt(i)==')')
            close++;

            else
            open++;
        }

        return open+close;
    }
}