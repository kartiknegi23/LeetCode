class Solution {

    public StringBuilder reverse(int start, StringBuilder result){
        StringBuilder str = new StringBuilder();
        

        for(int i=0;i<start;i++){
            str.append(result.charAt(i));
        }

        for(int i=result.length()-1;i>=start;i--){
            str.append(result.charAt(i));
        }

        return str;
    }

    public String reverseParentheses(String s) {
        Stack<Integer>stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(result.length());
            }

            else if(s.charAt(i)==')'){
                result = reverse(stack.peek(), result);
                stack.pop();
            }

            else{
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }
}