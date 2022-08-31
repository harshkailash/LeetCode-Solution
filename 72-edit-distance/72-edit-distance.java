class Solution {
    public int minDistance(String word1, String word2) {
     //1) Recursive  
       //return solve(word1,word2,0,0);
        
    //2) Memorization 
    /* int[][] dp=new int[word1.length()+1][word2.length()+1];
     return Solve_Memo(word1,word2,0,0,dp); */
        
    //DP (Bottom up dp)
       if(word1.length()==0)
         return word2.length();
       if(word2.length()==0)
         return word1.length();
         
       return DP(word1,word2); 
        
    }
    //--------------------------------------------
   //Recursive 
   private static int solve(String a,String b,int i,int j)
   {
     if(i==a.length())
       return b.length()-j;
     
     if(j==b.length())    
       return a.length()-i; 
     
  
     int ans=0;        //simultaneously we are also handling the case if(i & j ==length of both means having same length).if the below if block runs always that means both strings are equal. and the ans will remain as it is i.e 0.
     if(a.charAt(i)==b.charAt(j))
     {
       return solve(a,b,i+1,j+1); //if both string get matched means we don't need to do all those three operations ,so there is 0 operations.
     }
     else{                        //everytime we are adding 1 because we are performing that operation.
       int insert=1+solve(a,b,i,j+1);
       int delete=1+solve(a,b,i+1,j);
       int replac=1+solve(a,b,i+1,j+1);
       
        ans=Math.min(insert,Math.min(delete,replac));
     }
     return ans; 
   }
    //--------------------------------------------
   //Memo 
   private static int Solve_Memo(String a,String b,int i,int j,int[][] dp)
   {
     if(i==a.length())
       return b.length()-j;
     
     if(j==b.length())    
       return a.length()-i; 
       
     if(dp[i][j]>0)
       return dp[i][j];
       
  
     int ans=0;       
     if(a.charAt(i)==b.charAt(j))
     {
       return Solve_Memo(a,b,i+1,j+1,dp);
     }
     else{                       
       int insert=1+Solve_Memo(a,b,i,j+1,dp);
       int delete=1+Solve_Memo(a,b,i+1,j,dp);
       int replac=1+Solve_Memo(a,b,i+1,j+1,dp);
       
        ans=Math.min(insert,Math.min(delete,replac));
     }
     return dp[i][j]=ans; 
   }
    //--------------------------------------------
   //DP (Bottom up dp)
   private static int DP(String a,String b)
   {
      int[][] dp=new int[a.length()+1][b.length()+1];
      int i,j=0;
      
      
      //Base Cases 
     for(j=0;j<b.length();j++)
     {
       dp[a.length()][j]=b.length()-j;
     }
     for(i=0;i<a.length();i++)
     {
       dp[i][b.length()]=a.length()-i;
     }
     
     //reversing the looping
     for(i=a.length()-1;i>=0;i--)
     {
       for(j=b.length()-1;j>=0;j--)
       {
         int ans=0;        
     if(a.charAt(i)==b.charAt(j))
     {
       ans= dp[i+1][j+1];
     }
     else{                        
       int insert=1+dp[i][j+1];
       int delete=1+dp[i+1][j];
       int replac=1+dp[i+1][j+1];
       
        ans=Math.min(insert,Math.min(delete,replac));
     }
       dp[i][j]=ans; 
       }
     }
     return dp[0][0];
   }
}
