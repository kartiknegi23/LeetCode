class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for(int i=0;i<num.length();i++){
            while(stack.size()>0 && num.charAt(i)<stack.peek() && count<k){
                stack.pop();
                count++;
            }

            stack.push(num.charAt(i));
        }

        while(count<k && stack.size()>0){
            stack.pop();
            count++;
        }

        String str = "";

        for(int i=0;i<stack.size();i++){
            if(str.length()==0 && stack.get(i)=='0')
            continue;

            str+=stack.get(i);
        }

        return str.length()==0? "0":str;
    }
}