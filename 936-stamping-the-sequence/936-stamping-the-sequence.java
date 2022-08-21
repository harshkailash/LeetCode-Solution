class Solution {

    public int[] movesToStamp(String stamp, String target) {
        char[] s = stamp.toCharArray();
        char[] t = target.toCharArray();
        boolean[] vis = new boolean[t.length];
        ArrayList<Integer> res = new ArrayList<>();
        int total = 0;
        while (total < t.length) {
            boolean flag = false;
            for (int i = 0; i <= t.length - s.length; i++) {
                if (vis[i] == false && canReplace(i, s, t)) {
                    total += doReplace(i, s, t);
                    vis[i] = true;
                    flag = true;
                    res.add(0, i);

                    if (total == t.length) {
                        break;
                    }
                }
            }

            if (flag == false) {
                return new int[0];
            }
        }

        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }

        return arr;
    }

    boolean canReplace(int ind, char[] s, char[] t) {
        // System.out.println(new String(t));
        for (int i = 0; i < s.length; i++) {
            if (t[ind + i] != '*' && s[i] != t[ind + i]) {
                return false;
            }
        }
        return true;
    }

    int doReplace(int ind, char[] s, char[] t) {
        int count = 0;
        for (int i = 0; i < s.length; i++) {
            if (t[i + ind] != '*') {
                t[i+ind] = '*';
                count++;
            }
        }

        return count;
    }
}