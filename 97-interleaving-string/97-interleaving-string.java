class Solution {
    Boolean[][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        dp=new Boolean[s1.length()+1][s2.length()+1];
        return isit(s1,s2,s3);
    }
    
    private boolean isit(String s1,String s2,String s3){
        int l1=s1.length();
        int l2=s2.length();
        int l3=s3.length();
        
        if(l1+l2!=l3)
            return false;
        
        if(l1==0 &&  l2==0 && l3==0)
            return true;
        
        if(dp[l1][l2]!=null)
            return dp[l1][l2];
        
        if(l1>0 && l2>0 && s1.charAt(0)==s3.charAt(0) && s2.charAt(0)==s3.charAt(0)){
            return dp[l1][l2]=isit(s1.substring(1),s2,s3.substring(1)) || isit(s1,s2.substring(1),s3.substring(1));
        }
        else if(l1>0 && s1.charAt(0)==s3.charAt(0)){
            return dp[l1][l2]=isit(s1.substring(1),s2,s3.substring(1));
        }
        else if(l2>0 && s2.charAt(0)==s3.charAt(0)){
            return dp[l1][l2]=isit(s1,s2.substring(1),s3.substring(1));
        }
        else
           return dp[l1][l2]=false;
    }
}