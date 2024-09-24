class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer>set = new HashSet<>();
        int result = 0;
        for(int i=0;i<arr1.length;i++){
            int val = arr1[i];
            while(!(set.contains(val)) && val>0){
                set.add(val);
                val/=10;
            }
        }

        for(int i=0;i<arr2.length;i++){
            int val = arr2[i];
            while(!(set.contains(val)) && val>0){
                val/=10;
            }
            if(val>0)
            result = Math.max(result, (int) Math.log10(val)+1);
        }

        return result;
    }
}