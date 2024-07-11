class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<t.length();i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0)+1);
        }

        int low=0;
        int high=0;

        int count = 0;
        int min_length = Integer.MAX_VALUE;
        int start_index = -1;
        while(high<s.length()){
            if(map.containsKey(s.charAt(high))){
                map.put(s.charAt(high), map.get(s.charAt(high))-1);
                if(map.get(s.charAt(high))==0)
                count++;
            }

            while(count==map.size()){
                
                if((high-low+1) < min_length){
                    start_index = low;
                    min_length = high-low+1;    
                }

                if(map.containsKey(s.charAt(low))){
                    map.put(s.charAt(low), map.get(s.charAt(low))+1);
                }
                if(map.get(s.charAt(low))!=null && map.get(s.charAt(low))>0)
                count--;

                low++;
            }

            high++;
        }


        if(start_index==-1)
        return "";

        StringBuilder result = new StringBuilder();

        for(int i=start_index;i<start_index+min_length;i++){
            result.append(s.charAt(i));
        }

        return result.toString();
    }
}