class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int global_min = arrays.get(0).get(0);
        int global_max = arrays.get(0).get(arrays.get(0).size()-1);

        int result = Integer.MIN_VALUE;

        for(int i=1;i<arrays.size();i++){
                int local_min = arrays.get(i).get(0);
                int local_max = arrays.get(i).get(arrays.get(i).size()-1);

                result = Math.max(result, Math.abs(local_min - global_max));
                result = Math.max(result, Math.abs(local_max - global_min));

                if(local_min<global_min)
                global_min=local_min;

                if(local_max>global_max)
                global_max=local_max;
            
        }

        return result;
    }
}