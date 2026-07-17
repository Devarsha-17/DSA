import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Start by adding the empty set
        result.add(new ArrayList<>());
        
        for (int num : nums) {
            int size = result.size();
            // Iterate through all existing subsets and add the current number to them
            for (int i = 0; i < size; i++) {
                List<Integer> subset = new ArrayList<>(result.get(i));
                subset.add(num);
                result.add(subset);
            }
        }
        
        return result;
    }
}