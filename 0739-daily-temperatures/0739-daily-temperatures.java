class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;
        int[] ans = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            // Remove all temperatures that are not warmer
            while (!stack.isEmpty() &&
                   temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }

            // If stack is empty, no warmer day
            if (stack.isEmpty()) {
                ans[i] = 0;
            } else {
                ans[i] = stack.peek() - i;
            }

            // Store current day's index
            stack.push(i);
        }

        return ans;
    }
}