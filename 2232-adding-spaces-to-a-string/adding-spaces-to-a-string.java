class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder str = new StringBuilder();
        int p = 0;
        int i=0;
        int j=0;
        int ind = 0;

        while(i<s.length()){
            if(j<spaces.length)
            ind = spaces[j];
            if(i==ind){
                str.append(" ");
                j++;
            }
            
            str.append(s.charAt(i));
            i++;
        }
        return str.toString();
    }
}