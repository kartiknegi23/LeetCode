class Solution {
    public int minSwaps(int[] nums) {
        Integer[] integerArray = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        ArrayList<Integer>list = new ArrayList<>(Arrays.asList(integerArray));
        list.addAll(Arrays.asList(integerArray));

        int count = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1)
            count++;
        }

        if(count<=1)
        return 0;

        int l = 0;
        int r = 0;
        int count1 = 0;
        int result = Integer.MAX_VALUE;

        while(r<list.size()){
            if(list.get(r)==1)
            count1++;

            if((r-l+1)==count){
                result = Math.min(result, count-count1);
                if(list.get(l)==1)
                count1--;
                l++;
            }

            
            r++;
        }
        return result;
    }

    
}