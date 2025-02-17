class Solution {
    public void solve(int[] nums, int[] arr, Set<List<Integer>> set, List<List<Integer>> list, List<Integer> current){
        if(current.size()==nums.length){
            if(!set.contains(current)){
                set.add(new ArrayList<Integer>(current));
                list.add(new ArrayList<Integer>(current));
            }
        }

        for(int i=0;i<nums.length;i++){
            if(arr[i]==1)
            continue;

            //take//
            arr[i] = 1;
            current.add(nums[i]);
            solve(nums, arr, set, list, current);

            //skip//
            arr[i]=0;
            current.remove(current.size()-1);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> current = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        int[] arr = new int[nums.length];

        solve(nums, arr, set, list, current);
        return list;
    }
}