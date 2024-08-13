class Solution {

    public void find_combination(int[] candidates, int target, List<Integer> list, List<List<Integer>> result, int index){
        if(target<0)
        return;

        if(target==0)
        {
            result.add(new ArrayList<>(list));
            return ;
        }

        for(int i=index;i<candidates.length;i++){
            if(i>index && candidates[i] == candidates[i-1])
            continue;

            list.add(candidates[i]);
            find_combination(candidates, target-candidates[i], list, result, i+1);

            list.remove(list.size()-1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer>list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        find_combination(candidates, target, list, result, 0);

        return result;
    }
}