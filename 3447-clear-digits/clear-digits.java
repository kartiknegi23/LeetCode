class Solution {
    public String clearDigits(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i)) && stack.size()>0)
            stack.pop();

            else
            stack.push(s.charAt(i));
        }

        StringBuilder str = new StringBuilder();
        while(stack.size()>0){
            str.append(stack.pop());
        }
        return str.reverse().toString();
    }
}