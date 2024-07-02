class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer>list = new ArrayList<>();
        Map<Integer, Integer>hashmap1 = new HashMap<>();

        for(int i=0;i<nums1.length;i++){
            if(hashmap1.containsKey(nums1[i]))
            hashmap1.put(nums1[i], hashmap1.get(nums1[i])+1);

            else
            hashmap1.put(nums1[i], 1);
        }

        for(int i=0;i<nums2.length;i++){
            if(hashmap1.containsKey(nums2[i])){
                hashmap1.put(nums2[i], hashmap1.get(nums2[i])-1);
                if(hashmap1.get(nums2[i])==0)
                hashmap1.remove(nums2[i]);

                list.add(nums2[i]);
            }
        }

        int[] result = new int[list.size()];
        for(int i=0;i<result.length;i++){
            result[i] = list.get(i);
        }
        
        return result;
    }
}