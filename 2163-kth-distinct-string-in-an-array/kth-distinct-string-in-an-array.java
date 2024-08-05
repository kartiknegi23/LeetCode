class Solution {
    public String kthDistinct(String[] arr, int k) {
        int count=0;
        Map<String, Integer>map = new LinkedHashMap<>();

        for(int i=0;i<arr.length;i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        } 

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            String key = entry.getKey();
            Integer value = entry.getValue();

            

            if(value==1)
            count++;

            if(count==k)
            return key;
        }

        return ""; 
    }
}