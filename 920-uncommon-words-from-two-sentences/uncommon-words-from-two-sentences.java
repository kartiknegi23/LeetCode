class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer>map = new HashMap<>();
        List<String> list = new ArrayList<>();


        String[] words1 = s1.split(" ");
        String[] words2 = s2.split(" ");

        for(int i=0;i<words1.length;i++){
            if(map.containsKey(words1[i]))
            map.put(words1[i], map.get(words1[i])+1);

            else
            map.put(words1[i], 1);
        }

        for(int i=0;i<words2.length;i++){
            if(map.containsKey(words2[i]))
            map.put(words2[i], map.get(words2[i])+1);

            else
            map.put(words2[i], 1);
        }

        for(Map.Entry<String, Integer>entry : map.entrySet()){
            if(entry.getValue()==1)
            list.add(entry.getKey());
        }

        String[] result = list.toArray(new String[0]);
        
        return result;
    }
}