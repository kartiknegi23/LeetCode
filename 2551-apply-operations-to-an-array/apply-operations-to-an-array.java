class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if(nums[i] == nums[i+1]){
                nums[i] = nums[i]*2;
                nums[i+1] = 0;
            }
        }

        List<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(nums[i]!=0)
            list.add(nums[i]);
        }

        int idx = 0;
        for(int i=0;i<list.size();i++){
            nums[idx] = list.get(i);
            idx++;
        }

        while(idx<n){
            nums[idx] = 0;
            idx++;
        }

        return nums;

    }
}