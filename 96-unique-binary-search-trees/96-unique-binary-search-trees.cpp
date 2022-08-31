class Solution {
public:
    int numTrees(int n) {
        int sum = 0;
        int dp[n+1];
        memset(dp, -1, sizeof(dp));
        dp[0] = dp[1] = 1;
        return numTreeHelper(n, dp);
    }
    
    int numTreeHelper(int n, int dp[]){
        
        if( dp[n] != -1 ) return dp[n];
        int sum = 0;
        
        for(int i=1; i<=n; i++){
            
            sum += (numTreeHelper(i-1, dp) * numTreeHelper(n-i, dp));
        }
        return dp[n] = sum;
    }
};