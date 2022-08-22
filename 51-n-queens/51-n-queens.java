class Solution {
    public List<List<String>> solveNQueens(int n) {
        boolean [][] board = new boolean[n][n];
        List<List<String>> ans = new ArrayList();
        return queens(board,0,ans);
    }
    
    public static List<List<String>> queens(boolean [][] board, int row, List<List<String>>ans)
    {
        if(row == board.length){
           List<String> l = getList(board);
            ans.add(new ArrayList<>(l));
            return ans;
        }
        
        for(int col = 0;  col < board.length; col++){
             //place the queen if it is safe
            if(isSafe(board,row,col)){
                 board[row][col] = true;
                 queens(board,row+1,ans);
                 board[row][col] = false;
            }
        }
        return ans;
        
    }
    
     private static List<String> getList(boolean[][] board) {
         List<String> ds = new ArrayList();
         
        for (boolean [] row :board) {
            StringBuilder sb = new StringBuilder();
            
            for(boolean element: row){
                if(element){
                    sb.append("Q");
                }else{
                    sb.append(".");
                }
                
            }
            ds.add(sb.toString()); 
        }
         return ds;
        
     }
    
    public static boolean isSafe(boolean[][] board, int row, int col){
        //check vertical row
        for(int i = 0; i < row; i++){
           if(board[i][col]){
               return false;
           }
        }
        
        // check left diagonal
        int maxLeft = Math.min(row,col);
        
        for(int i = 1; i <= maxLeft; i++){
            if(board[row-i][col-i]){
                return false;
            }
        }
         // check right diagonal
        int maxRight = Math.min(row,board.length-col-1);
        
        for(int i = 1; i <= maxRight; i++){
            if(board[row-i][col+i]){
                return false;
            }
        }
        return true;  
    }
    
    
}