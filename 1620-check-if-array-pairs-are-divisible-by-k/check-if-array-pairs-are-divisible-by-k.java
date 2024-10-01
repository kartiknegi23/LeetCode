class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] remainder = new int[arr.length];
        Map<Integer, Integer>hashmap = new HashMap<>();
        for(int i=0;i<remainder.length;i++){
            remainder[i] = (arr[i]%k + k)%k;
            hashmap.put(remainder[i], hashmap.getOrDefault(remainder[i], 0)+1);
        }

        if(hashmap.containsKey(0) && hashmap.get(0)%2!=0)
        {
            return false;}

        for(int rem=1;rem<=k/2;rem++){
            int remFreq = hashmap.getOrDefault(rem, 0);
            int complementFreq = hashmap.getOrDefault(k - rem, 0);
            
            if (remFreq != complementFreq) {
                return false;
            }
        }

        return true;

    }
}