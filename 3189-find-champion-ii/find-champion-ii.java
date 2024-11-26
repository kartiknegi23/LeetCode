class Solution {
    public int findChampion(int n, int[][] edges) {
        HashSet<Integer>set = new HashSet<>();
        if(n==1)
        return 0;

        if(edges.length==0)
        return -1;

        if(edges.length<n-1)
        return -1;

        for(int i=0;i<n;i++){
            set.add(i);
        }

        for(int i=0;i<edges.length;i++){
            if(set.contains(edges[i][1]))
            set.remove(edges[i][1]);
        }

        if(set.size()>1)
        return -1;

        int ans = set.iterator().next();
        return ans;
    }
}