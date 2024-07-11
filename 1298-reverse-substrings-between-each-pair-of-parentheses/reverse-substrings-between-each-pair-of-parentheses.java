class Solution {
    public String reverseParentheses(String s) {
        int count = 0;
        int flag = 1;
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            }
            else if(s.charAt(i)==')'){
                int j = stack.pop();
                map.put(j, i);
                map.put(i, j);
            }
            else{
                count++;
            }
        }

        char[] str = new char[count];
        int index = 0;

        for(int i=0;i<s.length();i+=flag){
            if(s.charAt(i)=='(' || s.charAt(i)==')'){
                i=map.get(i);
                flag = -flag;
            }

            else{
                str[index]=s.charAt(i);
                index++;
            }
        }

        return new String (str);
    }
}