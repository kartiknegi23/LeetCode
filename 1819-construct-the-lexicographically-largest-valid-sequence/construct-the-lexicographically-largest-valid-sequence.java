class Solution {
    public boolean solve(int i, int n, Set<Integer> used, int[] result){
        if(i>=result.length)
        return true;

        if(result[i]!=-1)
        return solve(i+1, n, used, result);

        for(int num=n;num>=1;num--){
            if(used.contains(num))
            continue;
            
            result[i] = num;
            used.add(num);

            if(num==1){
                if(solve(i+1,n,used, result) == true)
                return true;
            }
            else{
                int j = i+result[i];
                if(j<result.length && result[j]==-1){
                    result[j] = num;
                    if(solve(i+1, n, used, result)==true)
                    return true;

                    result[j]=-1;
                }
            }

            result[i] = -1;
            used.remove(num);
        }

        return false;
    }

    public int[] constructDistancedSequence(int n) {
        Set<Integer> used = new HashSet<>();
        int[] result = new int[n*2-1];
        Arrays.fill(result, -1);
        
        solve(0, n, used, result);
        return result; 
    }
}