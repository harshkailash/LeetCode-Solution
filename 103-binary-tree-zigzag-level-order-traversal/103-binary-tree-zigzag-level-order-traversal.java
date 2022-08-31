class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        q.add(root);
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> add = new LinkedList<>();
            for (int i = 0; i < size; i ++) {
                TreeNode node = q.poll();
                if (level % 2 == 0) {
                    add.add(node.val);
                }
                else {
                    add.add(0, node.val);
                }
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            res.add(add);
            level ++;
        }
        return res;
    }
}