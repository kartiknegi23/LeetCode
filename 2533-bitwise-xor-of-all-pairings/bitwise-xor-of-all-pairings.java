class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        Map<Integer, Integer> hashmap = new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            hashmap.put(nums1[i], hashmap.getOrDefault(nums1[i], 0)+nums2.length);
        }

        for(int i=0;i<nums2.length;i++){
            hashmap.put(nums2[i], hashmap.getOrDefault(nums2[i], 0)+nums1.length);
        }

        int result = 0;

        for(Map.Entry<Integer, Integer> entry : hashmap.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();

            if(value%2 != 0){
                result = result^key;
            }
        }
        return result;
    }
}