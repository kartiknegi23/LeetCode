class Solution {
    public int maximumLength(String s) {
        HashMap<String, Integer> hashmap = new HashMap<>(); 

        for(int i=0;i<s.length();i++){
            
            String st = "";
            st+=s.charAt(i);
            hashmap.put(st, hashmap.getOrDefault(st, 0)+1);

            for(int j=i+1;j<s.length();j++){
                if(s.charAt(j) != s.charAt(i)){
                    break;
                }
                st+=s.charAt(j);
                hashmap.put(st, hashmap.getOrDefault(st, 0)+1);
            }
        }

        int result = -1;
        for(Map.Entry<String, Integer> entry : hashmap.entrySet()){
            String key = entry.getKey();
            int value = entry.getValue();
            if(value>=3)
            result = Math.max(result, key.length());
        }
        return result;
    }
}