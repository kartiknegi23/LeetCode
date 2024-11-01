class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        int[] lds = new int[nums.length];
        int[] hash = new int[nums.length];
        Arrays.fill(lds, 1);
        int last_index = 0;
        int maxi = 0;

        for(int i=1;i<nums.length;i++){
            hash[i] = i;
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0 && (lds[i]<lds[j]+1)){
                    lds[i]=lds[j]+1;
                    hash[i] = j;
                }
            }
            if(lds[i]>maxi)
            {
                maxi = lds[i];
                last_index = i;
            }
        }

        list.add(nums[last_index]);

        while(last_index != hash[last_index]){
            last_index = hash[last_index];
            list.add(nums[last_index]);
        }

        Collections.reverse(list);
        return list;
    }
}