import java.util.*;

class Solution {
    public void find_combination(int[] candidates, int target, List<Integer> list, List<List<Integer>> parent, int index, int sum) {
        if (sum > target) return;

        if (sum == target) {
            parent.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            // Skip duplicates
            if (i > index && candidates[i] == candidates[i - 1]) continue;

            list.add(candidates[i]);
            find_combination(candidates, target, list, parent, i + 1, sum + candidates[i]);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> parent = new ArrayList<>();

        find_combination(candidates, target, list, parent, 0, 0);

        return parent;
    }
}
