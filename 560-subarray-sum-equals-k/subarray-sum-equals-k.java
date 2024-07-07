class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        int prefix_sum = 0;

        for (int i = 0; i < nums.length; i++) {
            prefix_sum += nums[i];

            count += map.getOrDefault(prefix_sum - k, 0);
            map.put(prefix_sum, map.getOrDefault(prefix_sum, 0) + 1);
        }

        return count;

    }
}