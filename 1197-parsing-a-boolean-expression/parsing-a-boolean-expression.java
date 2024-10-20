class Solution {
    public char solve(List<Boolean>list, char operator){
        boolean result = list.get(0);
        if(operator=='!'){
            result = !result;
            return result==false? 'f' : 't';
        }

        for(int i=1;i<list.size();i++){
            if(operator=='|')
            result = result || list.get(i);

            else if(operator=='&')
            result = result && list.get(i);
        }
        return result==false? 'f' : 't';
    }

    public boolean parseBoolExpr(String expression) {
        Stack<Character>stack = new Stack<>();
        for(int i=0;i<expression.length();i++){
            if(expression.charAt(i)=='&' || expression.charAt(i)=='|' || expression.charAt(i)=='!' || expression.charAt(i)=='(' || expression.charAt(i)=='f' || expression.charAt(i)=='t'){
                stack.push(expression.charAt(i));
            }

            else if(expression.charAt(i)==')'){
                List<Boolean> list = new ArrayList<>();
                while(stack.peek()!='('){
                    if(stack.peek()=='f')
                    list.add(false);

                    else if(stack.peek()=='t')
                    list.add(true);

                    stack.pop();
                }
                stack.pop();
                char operator = stack.pop();
                char result = solve(list, operator);
                stack.push(result);
            }
        }

        return stack.peek()=='f'? false : true;
    }
}