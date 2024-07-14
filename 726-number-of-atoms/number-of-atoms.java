class Solution {
    public String countOfAtoms(String formula) {
        Stack<HashMap<String, Integer>> stack = new Stack<>();
        HashMap<String, Integer> hashmap = new HashMap<>();
        stack.push(hashmap);
        int i=0;
        int n=formula.length();

        while(i<formula.length()){
            if(formula.charAt(i)=='('){
                HashMap<String, Integer> newmap = new HashMap<>();
                stack.push(newmap);
                i++;
            }

            else if(formula.charAt(i)==')'){
                HashMap<String, Integer> currentmap = stack.pop();
                i++;

                StringBuilder multiplier = new StringBuilder();
                while(i<n && Character.isDigit(formula.charAt(i))){
                    multiplier.append(formula.charAt(i));
                    i++;
                } 

                if(multiplier.length()!=0){
                    for(Map.Entry<String, Integer> entry : currentmap.entrySet()){
                        int number_multiplier = Integer.parseInt(multiplier.toString());
                        String key = entry.getKey();
                        int value = entry.getValue();
                        int newvalue = value*number_multiplier;

                        entry.setValue(newvalue);
                    }
                }

                

                for(Map.Entry<String, Integer> entry : currentmap.entrySet()){
                    String key = entry.getKey();
                    int value = entry.getValue();

                    stack.peek().put(key, stack.peek().getOrDefault(key, 0)+value);
                }

            }

            else{
                StringBuilder element = new StringBuilder();
                element.append(formula.charAt(i));
                i++;

                while(i<n && Character.isLetter(formula.charAt(i)) && Character.isLowerCase(formula.charAt(i))){
                    element.append(formula.charAt(i));
                    i++;
                }

                StringBuilder frequency = new StringBuilder();
                
                while(i<n && Character.isDigit(formula.charAt(i))){
                    frequency.append(formula.charAt(i));
                    i++;
                }

                int number_frequency = frequency.length()==0 ? 1 : Integer.parseInt(frequency.toString());

                stack.peek().put(element.toString(), stack.peek().getOrDefault(element.toString(), 0)+number_frequency);
            }
        }

        TreeMap<String, Integer> treemap = new TreeMap<>();

        for(Map.Entry<String, Integer> entry : stack.peek().entrySet()){
            String key = entry.getKey();
            int value = entry.getValue();

            treemap.put(key, value);
        }

        StringBuilder result = new StringBuilder();

        for(Map.Entry<String, Integer> entry : treemap.entrySet()){
            String key = entry.getKey();
            int value = entry.getValue();
            result.append(key);
            if(value>1)
            result.append(value);
        }

        return result.toString();
    }
}