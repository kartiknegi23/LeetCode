class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();


        if(n>m)
        return false;

        char[] arr =  s1.toCharArray();
        Arrays.sort(arr);
        String str = new String(arr);

        for(int i=0;i<=m-n;i++){
            String sub_str = s2.substring(i, i+n);
            
            char[] ch = sub_str.toCharArray();
            Arrays.sort(ch);
            String new_str = new String(ch);

            if(str.equals(new_str))
            return true;
        }

        return false;
    }
}