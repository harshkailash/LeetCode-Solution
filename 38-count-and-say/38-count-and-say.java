public class Solution {
    public String countAndSay(int n) {
        String result = "";
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                result = "1";
                continue;
            }
            result = process(result);
        }
        return result;
    }
    private String process(String s) {
        String result = "";
        char curr = s.charAt(0);
        int count = 1;
        for (int i = 1; i < s.length(); i ++) {
            if (s.charAt(i) != curr) {
                result += (count + "") + curr;
                curr = s.charAt(i);
                count = 1;
                continue;
            }
            count ++;
        }
        result += (count + "" )+ curr;
        return result;
    }
}