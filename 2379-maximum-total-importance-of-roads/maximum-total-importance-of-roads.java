class Solution {
    public long maximumImportance(int n, int[][] roads) {
        Map<Integer, Integer> hashmap = new TreeMap<>();
        int[] arr = new int[n];
        long result = 0;

        for(int i=0;i<roads.length;i++){
            for(int j=0;j<2;j++){
                if(hashmap.containsKey(roads[i][j]))
                hashmap.put(roads[i][j], hashmap.get(roads[i][j])+1);

                else
                hashmap.put(roads[i][j], 1);
            }
        }

        AtomicInteger node = new AtomicInteger(n);
        hashmap.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .forEach(entry -> {
                    arr[entry.getKey()] = node.getAndDecrement();
                    });

        for(int i=0;i<roads.length;i++){
            result+= arr[roads[i][0]] + arr[roads[i][1]];
        }

        return result;
    }
}