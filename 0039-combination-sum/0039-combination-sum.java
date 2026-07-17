class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        backtrack(candidates, target, 0, new ArrayList<>());

        return result;
    }

    private void backtrack(int[] candidates,
                           int target,
                           int index,
                           List<Integer> current) {

        // Found a valid combination
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Invalid path
        if (target < 0 || index == candidates.length) {
            return;
        }

        // Choose the current number
        current.add(candidates[index]);
        backtrack(candidates, target - candidates[index], index, current);

        // Backtrack
        current.remove(current.size() - 1);

        // Skip the current number
        backtrack(candidates, target, index + 1, current);
    }
}