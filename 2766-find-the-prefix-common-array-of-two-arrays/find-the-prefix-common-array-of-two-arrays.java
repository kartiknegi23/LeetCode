class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] result = new int[A.length];
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<A.length;i++){
            set.add(A[i]);
            int count = 0;
            for(int j=0;j<=i;j++){
                if(set.contains(B[j]))
                count++;
            }   
            result[i] = count;
            count = 0;
        }
        return result;
    }
}