class Solution {
    public String countOfAtoms(String formula) {
        Stack<HashMap<String, Integer>> stack = new Stack<>();
        HashMap<String, Integer> hashmap = new HashMap<>();
        stack.push(hashmap);
        int i=0;
        int n=formula.length();

        while(i<formula.length()){  // Traverse the string //
            if(formula.charAt(i)=='('){  // If we find '(' we make a new hashmap and it in the stack //
                HashMap<String, Integer> newmap = new HashMap<>();
                stack.push(newmap);
                i++;
            }

            else if(formula.charAt(i)==')'){    // We pop the stack and get the elements from the top hashmap and merge it with the hashmap below it //
                HashMap<String, Integer> currentmap = stack.pop();
                i++;

                StringBuilder multiplier = new StringBuilder();     // We check if there is any multiplier outise the bracket //
                while(i<n && Character.isDigit(formula.charAt(i))){
                    multiplier.append(formula.charAt(i));
                    i++;
                } 

                if(multiplier.length()!=0){     //If there is a multiplier, we multiply the current element's frequency by that multiplier //
                    for(Map.Entry<String, Integer> entry : currentmap.entrySet()){
                        int number_multiplier = Integer.parseInt(multiplier.toString());
                        String key = entry.getKey();
                        int value = entry.getValue();
                        int newvalue = value*number_multiplier;

                        entry.setValue(newvalue);
                    }
                }

                

                for(Map.Entry<String, Integer> entry : currentmap.entrySet()){      // Merge the popped hashmap with the current hashmap at the top of stack //
                    String key = entry.getKey();
                    int value = entry.getValue();

                    stack.peek().put(key, stack.peek().getOrDefault(key, 0)+value);
                }

            }

            else{       // If only the element name is at this point //
                StringBuilder element = new StringBuilder();
                element.append(formula.charAt(i));
                i++;

                while(i<n && Character.isLetter(formula.charAt(i)) && Character.isLowerCase(formula.charAt(i))){        //We check if there is any suffix to the element symbol like a lowercase character //
                    element.append(formula.charAt(i));
                    i++;
                }

                StringBuilder frequency = new StringBuilder();
                
                while(i<n && Character.isDigit(formula.charAt(i))){     //Check the no. of atoms of that element ie. a number to it's right //
                    frequency.append(formula.charAt(i));
                    i++;
                }

                int number_frequency = frequency.length()==0 ? 1 : Integer.parseInt(frequency.toString());

                stack.peek().put(element.toString(), stack.peek().getOrDefault(element.toString(), 0)+number_frequency);    //Update the frequency in the top hashmap of stack //
            }
        }

        TreeMap<String, Integer> treemap = new TreeMap<>();     //Use treemap to sort the elements by name //

        for(Map.Entry<String, Integer> entry : stack.peek().entrySet()){
            String key = entry.getKey();
            int value = entry.getValue();

            treemap.put(key, value);
        }

        StringBuilder result = new StringBuilder();

        for(Map.Entry<String, Integer> entry : treemap.entrySet()){     // Store the element names and frequency in sorted order in a stringbuilder//
            String key = entry.getKey();
            int value = entry.getValue();
            result.append(key);
            if(value>1)
            result.append(value);
        }

        return result.toString();
    }
}