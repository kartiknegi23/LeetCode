class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int count =0;
        Arrays.sort(g);
        Arrays.sort(s);

        int i=0;
        int j=0;

        while(j<g.length && i<s.length){
            if(s[i]>=g[j]){
                count++;
                j++;
            }
            i++;
        }

        return count;
    }
}