class Solution{
  static void DFS(int[][] M, int i , int j , int ROW, int COL){
    //Time Complexity: O(n), where n is the total number of cells in the grid.
    //Space Complexity : O(min(ROW,COL)) due to recursion stack
    if(i < 0 || j < 0 || i > (ROW-1) || j > (COL-1) || M[i][j]!=1){
      return;
    }
    if(M[i][j] == 1){
      M[i][j] = 0;
      DFS(M, i+1 , j , ROW , COL );
       DFS(M, i-1 , j , ROW , COL );
       DFS(M, i , j+1 , ROW , COL );
       DFS(M, i , j-1 , ROW , COL );
       DFS(M, i+1 , j+1 , ROW , COL );
       DFS(M, i-1 , j-1 , ROW , COL );
       DFS(M, i+1 , j-1 , ROW , COL );
       DFS(M, i-1 , j+1 , ROW , COL ); 
    }
  }
  static int countIslands(int[][] M){
    int ROW = M.length;
    int COL = M[0].length;
    int count = 0;
    for (int i=0; i < ROWl; i++){
      for (int j = 0;j < COL; j++){
        if(M[i][j] == 1){
          count++;
          DFS(M,i,j,ROW,COL);
        } 
      }
    }
    return count;
  }
}
