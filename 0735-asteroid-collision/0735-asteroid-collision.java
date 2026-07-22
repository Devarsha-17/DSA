import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        for (int a : asteroids) {

            // Collision is possible only when:
            // Stack top is moving right (+)
            // Current asteroid is moving left (-)
            while (!stack.isEmpty() && stack.peek() > 0 && a < 0) {

                int diff = stack.peek() + a;

                // Stack asteroid is bigger
                if (diff > 0) {
                    a = 0;              // Current asteroid explodes
                }

                // Current asteroid is bigger
                else if (diff < 0) {
                    stack.pop();        // Remove the top asteroid
                }

                // Both are equal
                else {
                    stack.pop();        // Remove stack asteroid
                    a = 0;              // Current asteroid also explodes
                }
            }

            // Push only if current asteroid is still alive
            if (a != 0) {
                stack.push(a);
            }
        }

        // Convert stack to array
        int[] result = new int[stack.size()];

        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}