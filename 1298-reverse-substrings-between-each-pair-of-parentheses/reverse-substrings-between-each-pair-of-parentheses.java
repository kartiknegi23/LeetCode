class Solution {

    public String reverse(int start, String result){
        String str = "";
        

        for(int i=0;i<start;i++){
            str+=result.charAt(i);
        }

        for(int i=result.length()-1;i>=start;i--){
            str+=result.charAt(i);
        }

        return str;
    }

    public String reverseParentheses(String s) {
        Stack<Integer>stack = new Stack<>();
        String result = "";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(result.length());
            }

            else if(s.charAt(i)==')'){
                result = reverse(stack.peek(), result);
                stack.pop();
            }

            else{
                result+=s.charAt(i);
            }
        }

        return result;
    }
}