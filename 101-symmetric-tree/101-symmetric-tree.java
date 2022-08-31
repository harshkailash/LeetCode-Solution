public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        // return recursion(root.left, root.right);
        return iterative(root);
    }
    private boolean recursion(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left != null && right != null && left.val == right.val) {
            return recursion(left.left, right.right) && recursion(left.right, right.left);
        }
        return false;
    }
    private boolean iterative(TreeNode root) {
        Stack<TreeNode> left = new Stack<TreeNode>();
        Stack<TreeNode> right = new Stack<TreeNode>();
        left.push(root.left);
        right.push(root.right);
        while (left.size() > 0) {
            TreeNode l = left.pop();
            TreeNode r = right.pop();
            if (l == null && r == null) {
                continue;
            }
            if (l != null && r != null && l.val == r.val) {
                left.push(l.left);
                right.push(r.right);
                left.push(l.right);
                right.push(r.left);
                continue;
            }
            return false;
        }
        return true;
    }
}