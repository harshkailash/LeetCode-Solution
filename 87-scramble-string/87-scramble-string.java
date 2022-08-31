class Solution {
    Map<String, Boolean> mp = new HashMap();
    public boolean isScramble(String s1, String s2) {
        String key = s1 + ":" + s2;
        boolean isScrambled = false;
        if(mp.containsKey(key))
            return mp.get(key);
        int n = s1.length();
        if(n==1)
            return s1.equals(s2);
        for(int i = 1; i<n; i++){
            String x = s1.substring(0, i);
            String y = s1.substring(i);
            String t1 = s2.substring(0, i);
            String t2 = s2.substring(i);
            String t3 = s2.substring(n-i);
            String t4 = s2.substring(0, n-i);
            if((isScramble(x, t1) && isScramble(y, t2)) || (isScramble(x, t3) && isScramble(y, t4))){
                isScrambled = true;
                break;
            }
        }
        mp.put(key, isScrambled);
        return isScrambled;
    }
}