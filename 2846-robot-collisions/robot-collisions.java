class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        TreeMap<Integer, Integer> leftmap = new TreeMap<>();
        TreeMap<Integer, Integer> rightmap = new TreeMap<>();

        LinkedHashMap<Integer, Integer> location_order = new LinkedHashMap<>();

        for(int i=0;i<positions.length;i++){
            location_order.put(positions[i], i);
        }

        for(int i=0;i<directions.length();i++){
            if(directions.charAt(i)=='R'){
                rightmap.put(positions[i], healths[i]);
            }

            else{
                leftmap.put(positions[i], healths[i]);
            }
        }


        PriorityQueue<Integer>queue = new PriorityQueue<>();

        for(Map.Entry<Integer, Integer> entry : rightmap.entrySet()){
            queue.add(entry.getKey());
        }
        
        for(Map.Entry<Integer, Integer> entry : leftmap.entrySet()){
            queue.add(entry.getKey());
        }

        List<Integer>list = new ArrayList<>();

        while(queue.size()>0){
            list.add(queue.poll());
        }

        int index = 0;
        boolean flag = true;
        Stack<Integer>stack = new Stack<>();

        while(index<list.size()){

            while(stack.size()>0 && rightmap.containsKey(stack.peek()) && leftmap.containsKey(list.get(index)) ){
                int health1 = rightmap.get(stack.peek());
                int health2 = leftmap.get(list.get(index));

                if(health1>health2){
                    rightmap.put(stack.peek(), rightmap.get(stack.peek())-1);
                    flag = false;
                    break;
                }

                else if(health1<health2){
                    stack.pop();
                    leftmap.put(list.get(index), leftmap.get(list.get(index))-1);
                    flag = true;
                }

                else{
                    stack.pop();
                    flag = false;
                    break;
                    
                }

            } 

            if(flag==true)
            stack.push(list.get(index));
            
            index++;
            flag = true;
        }

        List<Integer>result = new ArrayList<>();
        LinkedHashMap<Integer, Integer> total = new LinkedHashMap<>();

        while(stack.size()>0){
            if(rightmap.containsKey(stack.peek())){
                total.put(stack.peek(), rightmap.get(stack.peek()));
                stack.pop();
            }
            else{
                total.put(stack.peek(), leftmap.get(stack.peek()));
                stack.pop();
            }
        }

        for(int i=0;i<positions.length;i++){
            if(total.containsKey(positions[i])){
                result.add(total.get(positions[i]));
            }
        }


        return result;
    }
}