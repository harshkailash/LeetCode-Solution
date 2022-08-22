class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        Integer dp[][] = new Integer[obstacleGrid.length][obstacleGrid[0].length];
        return uniquePathsWithObstacles(obstacleGrid,0,0,dp);
    }
    
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid, int cx, int cy, Integer[][] dp) {
        int m = obstacleGrid.length -1;
        int n =obstacleGrid[0].length -1;
        if(cx > m || cy > n) {
            return 0;
        }
        if(obstacleGrid[cx][cy] == 1){
            return 0;
        }
        if(dp[cx][cy] != null) {
            return dp[cx][cy];
        }
        if(cx == m && cy==n) {
            return 1;
        }
        int path1 = uniquePathsWithObstacles(obstacleGrid,cx+1,cy,dp);
        int path2 = uniquePathsWithObstacles(obstacleGrid,cx,cy+1,dp);
        dp[cx][cy] = path1 + path2;
        return dp[cx][cy];
        
        
    }
}