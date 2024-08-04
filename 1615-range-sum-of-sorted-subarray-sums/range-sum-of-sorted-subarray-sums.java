class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int MOD = 1000000007;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int sum = nums[i];
            list.add(sum);
            for(int j=i+1;j<nums.length;j++){
                sum+=nums[j];
                list.add(sum);
            }
        }

        Collections.sort(list);

        int result = 0;
        for(int i=left-1;i<=right-1;i++){
            result+=list.get(i);
            result = result%MOD;
        }

        return result%MOD;
    }
}