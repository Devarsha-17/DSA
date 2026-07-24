class Solution {

    public boolean isValidBST(TreeNode root) {
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean check(TreeNode root, long min, long max) {

        // Empty tree is always valid
        if (root == null) {
            return true;
        }

        // Current node must be between min and max
        if (root.val <= min || root.val >= max) {
            return false;
        }

        // Check left and right subtrees
        return check(root.left, min, root.val) &&
               check(root.right, root.val, max);
    }
}