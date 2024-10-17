class Solution {
    public int maximumSwap(int num) {
        StringBuilder nums = new StringBuilder(String.valueOf(num));
        int result = 0;
        int[] rightmax = new int[nums.length()];
        rightmax[rightmax.length-1] = rightmax.length-1;
        for(int i=rightmax.length-2;i>=0;i--){
            int right_max = rightmax[i+1];
            int right_max_element = nums.charAt(right_max)-'a';
            int current = nums.charAt(i)-'a';
            rightmax[i] = current > right_max_element ? i : rightmax[i+1];
        }

        for(int i=0;i<nums.length();i++){
            int current = nums.charAt(i)-'0';
            int next = nums.charAt(rightmax[i])-'0';
            if(current<next){
                char temp = nums.charAt(i);
                nums.setCharAt(i, nums.charAt(rightmax[i]));
                nums.setCharAt(rightmax[i], temp);
                break; 
            }
        }

        return Integer.parseInt(nums.toString());
    }
}