class Solution {
    public int minSwaps(String s) {
        int count = 0;
        Stack<Character>stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(stack.size()==0 && s.charAt(i)==']')
            count++;

            else if(s.charAt(i)==']'){
                stack.pop();
            }    

            else
            stack.push(s.charAt(i));
        }

        return (count+1)/2;
    }
}