class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character>stack = new Stack<>();
        int count = 0; 
        for(int i=0;i<s.length();i++){
            if(stack.size()>0  && s.charAt(i) == ')'){
                stack.pop();
            }

            else if(s.charAt(i)==')')
            count++;

            else
            stack.push(s.charAt(i));
        }

        return count+stack.size();
    }
}