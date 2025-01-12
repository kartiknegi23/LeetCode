class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if(n%2!=0)
        return false;

        Stack<Integer> open = new Stack<>();
        Stack<Integer> openclose = new Stack<>();

        for(int i=0;i<s.length();i++){
            if(locked.charAt(i) == '0'){
                openclose.push(i);
            }
            else if(s.charAt(i) == '('){
                open.push(i);
            }
            else if(s.charAt(i) == ')'){
                if(open.size() > 0)
                open.pop();

                else if(openclose.size() > 0)
                openclose.pop();

                else
                return false;
            }
        }

        while(open.size()>0 && openclose.size()>0 && open.peek() < openclose.peek()){
            open.pop();
            openclose.pop();
        }

        if(open.size()>0)
        return false;

        else
        return true;
    }
}