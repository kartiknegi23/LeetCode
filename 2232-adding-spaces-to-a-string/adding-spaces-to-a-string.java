class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder str = new StringBuilder(s);
        int p = 0;
        for(int i=0;i<spaces.length;i++){
            int ind = spaces[i];
            str.insert(ind+p, ' ');
            p++;
        }
        return str.toString();
    }
}