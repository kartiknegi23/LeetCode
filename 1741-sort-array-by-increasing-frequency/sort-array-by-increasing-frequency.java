class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        Integer[] arr = new Integer[nums.length];
        for(int i=0;i<nums.length;i++){
            hashmap.put(nums[i], hashmap.getOrDefault(nums[i], 0)+1);
            arr[i]=nums[i];
        }
        
        Arrays.sort(arr, (a,b)->{
            if(hashmap.get(a)!=hashmap.get(b)){
                return hashmap.get(a)-hashmap.get(b);
            }
            else{
                return b-a;
            }
        });

        for(int i=0;i<nums.length;i++){
            nums[i]=arr[i];
        }

        return nums;
    }
}