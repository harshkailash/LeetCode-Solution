class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> miss = new HashMap<Character, Integer>();
        HashSet<Character> chars = new HashSet<Character>();
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i ++) {
            char c = t.charAt(i);
            chars.add(c);
            if (!miss.containsKey(c)) {
                miss.put(c, 0);
            }
            if (!count.containsKey(c)) {
                count.put(c, 0);
            }
            miss.put(c, miss.get(c) + 1);
        }
        int left = -1, right = 0;
        int min = Integer.MAX_VALUE;
        String res = "";
        int target = t.length();
        int matched = 0;
        while (right <= s.length()) {
            if (matched == target) {
                String cand = s.substring(left, right);
                if (cand.length() < min) {
                    min = cand.length();
                    res = cand;
                }
                char toremove = s.charAt(left);
                count.put(toremove, count.get(toremove) - 1);
                if (count.get(toremove) < miss.get(toremove)) {
                    matched --;
                }
                left ++;
                while (left < right && !chars.contains(s.charAt(left))) {
                    left ++;
                }
                continue;
            }
            if (right == s.length()) {
                break;
            }
            char c = s.charAt(right);
            if (chars.contains(c)) {
                if (matched == 0) {
                    left = right;
                }
                count.put(c, count.get(c) + 1);
                if (count.get(c) <= miss.get(c)) {
                    matched ++;
                }
            }
            right ++;
        }
        return res;
    }
}