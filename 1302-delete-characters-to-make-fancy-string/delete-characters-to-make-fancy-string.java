class Solution {
    public String makeFancyString(String s) {
        StringBuilder str = new StringBuilder();
        int i = 0;
        int j = 0;
        int freq = 1;

        while(j<s.length()){
            if(j==0){
                str.append(s.charAt(j));
                j++;
                continue;
            }
            else if(s.charAt(j)==s.charAt(j-1)){
                freq++;
            }
            else
            freq = 1;

            if(freq<=2)
            str.append(s.charAt(j));
            j++;
        }

        return str.toString();
    }
}