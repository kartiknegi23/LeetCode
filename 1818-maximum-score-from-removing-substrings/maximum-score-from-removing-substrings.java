class Solution {

    public int greedy1(String s, int x, int y){
        Stack<Character>stack = new Stack<>();
        Stack<Character>stack2 = new Stack<>();

        int sum=0;

        for(int i=0;i<s.length();i++){
            if(stack.size()>0 && stack.peek()=='a' && s.charAt(i)=='b'){
                stack.pop();
                sum+=x;
            }

            else
            stack.push(s.charAt(i));
        }

        for(int i=0;i<stack.size();i++){
            if(stack2.size()>0 && stack2.peek()=='b' && stack.get(i)=='a'){
                stack2.pop();
                sum+=y;
            }

            else
            stack2.push(stack.get(i));
        }


        return sum;
    }

    public int greedy2(String s, int y, int x){
        Stack<Character>stack = new Stack<>();
        Stack<Character>stack2 = new Stack<>();
        int sum=0;

        for(int i=0;i<s.length();i++){
            if(stack.size()>0 && stack.peek()=='b' && s.charAt(i)=='a'){
                stack.pop();
                sum+=y;
            }

            else
            stack.push(s.charAt(i));
        }

        for(int i=0;i<stack.size();i++){
            if(stack2.size()>0 && stack2.peek()=='a' && stack.get(i)=='b'){
                stack2.pop();
                sum+=x;
            }

            else
            stack2.push(stack.get(i));
        }

        return sum;
    }

    public int maximumGain(String s, int x, int y) {
        
        return x>y? greedy1(s, x, y): greedy2(s, y, x);
    }
}