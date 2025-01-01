class Solution {
    public int maxScore(String s) {
        int result = 0;
        int idx=0;

        while(idx<s.length()-1){
            int z_count = 0;
            for(int i=0;i<=idx;i++){
                if(s.charAt(i)=='0')
                z_count++;
            }
            int o_count = 0;
            for(int i=idx+1;i<s.length();i++){
                if(s.charAt(i)=='1')
                o_count++;
            }
            result = Math.max(result, z_count + o_count);
            idx++;
        }

        return result;
    }
}