class Solution {
    public int minLength(String s) {
        Stack<Character>stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(stack.size()==0){
                stack.push(s.charAt(i));    
            }
            
            else if((s.charAt(i)=='B' && stack.peek()=='A') || (s.charAt(i)=='D' && stack.peek()=='C'))
                stack.pop();

            else
            stack.push(s.charAt(i));
        }

        return stack.size();
    }
}