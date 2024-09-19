class Solution {
    public List<Integer> solve(String expression){
        List<Integer>result = new ArrayList<>();

        for(int i=0;i<expression.length();i++){
            if(expression.charAt(i)=='+' || expression.charAt(i)=='-' || expression.charAt(i)=='*'){
                List<Integer>left = new ArrayList<>();
                left = solve(expression.substring(0,i));

                List<Integer>right = new ArrayList<>();
                right = solve(expression.substring(i+1));

                for(int j=0;j<left.size();j++){
                    for(int k=0;k<right.size();k++){
                        if(expression.charAt(i)=='+')
                        result.add(left.get(j) + right.get(k));

                        else if(expression.charAt(i)=='-')
                        result.add(left.get(j) - right.get(k));

                        else if(expression.charAt(i)=='*')
                        result.add(left.get(j) * right.get(k));
                    }
                }
            }

        }

        if(result.size()==0)
            result.add(Integer.parseInt(expression));

            return result;
    }

    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer>result = new ArrayList<>();
        
        return solve(expression);

    }
}