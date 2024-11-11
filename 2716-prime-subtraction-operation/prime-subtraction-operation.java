class Solution {
    public boolean isPrime(int num){
        if(num<=1)
        return false;

        for(int i=2;i<num;i++){
            if(num%i==0)
            return false;
        }

        return true;
    }

    public boolean primeSubOperation(int[] nums) {
        int prev = -1;

        for(int i=0;i<nums.length;i++){
            for(int j=nums[i]-1;j>0;j--){

                if(isPrime(j) && (nums[i]-j) > prev){
                    nums[i] = nums[i]-j;
                    break;
                }
            }
            if(nums[i]<=prev)
            {
                return false;
            }

            prev = nums[i];
        }

        return true;
    }
}