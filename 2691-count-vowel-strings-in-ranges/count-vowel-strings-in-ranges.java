class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] prefix = new int[words.length];
        int[] ans = new int[queries.length];
        Set<Character> hashset = new HashSet<>();
        hashset.add('a');
        hashset.add('e');
        hashset.add('i');
        hashset.add('o');
        hashset.add('u');

        if(hashset.contains(words[0].charAt(0)) && hashset.contains(words[0].charAt(words[0].length()-1)))
            prefix[0]++;

        for(int i=1;i<words.length;i++){
            prefix[i]=prefix[i-1];
            
            if(hashset.contains(words[i].charAt(0)) && hashset.contains(words[i].charAt(words[i].length()-1)))
            prefix[i]=prefix[i-1]+1;
        }

        for(int i=0;i<queries.length;i++){
            int l = queries[i][0];
            int r = queries[i][1];

            if(l==0)
            ans[i] = prefix[r];

            else{
                ans[i] = prefix[r]-prefix[l-1];
            } 
        }

        return ans;
    }
}