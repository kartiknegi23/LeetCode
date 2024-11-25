class Solution {
    public int slidingPuzzle(int[][] board) {
        StringBuilder start = new StringBuilder();
        for(int i=0;i<2;i++){
            for(int j=0;j<3;j++){
                start.append(board[i][j]);
            }
        }

        String target = "123450";

        Queue<String> queue = new LinkedList<>();
        queue.offer(start.toString());

        Map<Integer, int[]> hashmap = new HashMap<>();
        hashmap.put(0, new int[]{1,3});
        hashmap.put(1, new int[]{0,2,4});
        hashmap.put(2, new int[]{1,5});
        hashmap.put(3, new int[]{0, 4});
        hashmap.put(4, new int[]{1,3,5});
        hashmap.put(5, new int[]{2,4});

        Set<String> visited = new HashSet<>();
        visited.add(start.toString());
        int level = 0;

        while(queue.size()>0){
            int size = queue.size();
            
            while(size>0){
                String str = queue.poll();

                if(str.equals(target))
                return level;

                int zero_index=-1;
                for(int i=0;i<str.length();i++){
                    if(str.charAt(i)=='0'){
                        zero_index = i;
                        break;
                    }
                }

                for(int i=0;i<hashmap.get(zero_index).length;i++){
                    StringBuilder s = new StringBuilder(str);
                    char temp = s.charAt(zero_index);
                    s.setCharAt(zero_index, s.charAt(hashmap.get(zero_index)[i]));
                    s.setCharAt(hashmap.get(zero_index)[i], temp);

                    if(!visited.contains(s.toString())){
                        visited.add(s.toString());
                        queue.add((s.toString()));
                    }
                }
                size--;
            }
            level++;
        }   
        
        return -1;
    }
}