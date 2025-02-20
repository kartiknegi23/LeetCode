class Solution {
    public void getPerm(String[] nums, int n, Set<String> set, String str, String[] ans, StringBuilder current){
        if(current.length()==n){
            if(!set.contains(current.toString()))
            ans[0] = current.toString();

            return;
        }
        
        for(int i=0;i<=1;i++){
            if(ans[0] != null) 
            return;
            //take//
            current.append((char) (i+'0'));
            getPerm(nums, n, set, str, ans, current);
            
            //skip//
            current.deleteCharAt(current.length()-1);
        }
    }

    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        String str = "01";
        Set<String> set = new HashSet<>();
        String[] ans = new String[1];
        StringBuilder current = new StringBuilder();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }

        getPerm(nums, n, set, str, ans, current);

        return ans[0];
    }
}