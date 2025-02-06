class Solution {
    public int tupleSameProduct(int[] nums) {
        int tuples = 0;
        int n = nums.length;
        Arrays.sort(nums);

        for(int i=0;i<n;i++){
            for(int j=n-1;j>i;j--){
                Set<Integer> set = new HashSet<>();
                int p = nums[i]*nums[j];
                for(int k=i+1;k<j;k++){
                    if(p%nums[k]==0){
                        int d = p/nums[k];
                        if(set.contains(d)){
                            tuples++;
                        }
                        else
                        set.add(nums[k]);
                    }
                }
            }
        }
        return tuples*8;
    }
}