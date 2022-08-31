public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (n <= 0 || n < k)
            return result;
        ArrayList<Integer> current = new ArrayList<Integer>();
        dfs(n, k, 1, current, result); // because it need to begin from 1
        return result;
    }
    private void dfs(int n, int k, int start, ArrayList<Integer> current,
        List<List<Integer>> res) {
        if (current.size() == k) {
            res.add(new ArrayList<Integer>(current));
            return;
        }

        for (int i = start; i <= n; i++) {
            current.add(i);
            dfs(n, k, i + 1, current, res);
            current.remove(current.size() - 1);
        }
    }
}