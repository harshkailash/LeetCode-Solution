public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || inorder == null || postorder.length == 0 || inorder.length == 0 || postorder.length != inorder.length) {
            return null;
        }
        HashMap<Integer, Integer> inmap = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i ++) {
            inmap.put(inorder[i], i);
        }
        return gt(postorder, inorder, 0, postorder.length - 1, 0, inorder.length - 1, inmap);
    }
    private TreeNode gt(int[] post, int[] in, int postl, int postr, int inl, int inr, HashMap<Integer, Integer> inmap) {
        if (postl > postr) {
            return null;
        }
        TreeNode root = new TreeNode(post[postr]);
        int rootIndex = inmap.get(post[postr]);
        int leftnum = rootIndex - inl;
        TreeNode left = gt(post, in, postl, postl + leftnum -1, inl, rootIndex - 1, inmap);
        TreeNode right = gt(post, in,postl + leftnum, postr - 1, rootIndex + 1, inr, inmap);
        root.left = left;
        root.right = right;
        return root;
    }
}