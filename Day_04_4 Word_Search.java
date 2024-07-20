class Solution {
    public boolean exist(char[][] board, String word) {
      // Time Complexity : O(N x 3^L) where the N is the number of cells in the board(i.e ROWS x COLS) and L is the length of the word and for each cell the dfs function tracks 4 directions(up,down,left,right)
      // However we are using a path to set avoid revisiting cells , we are effectively moving 3 directions. so in worst case O(3^l)
      //Space Complexity : O(L)
        int ROWS = board.length;
        int COLS = board[0].length;
        boolean[][] path = new boolean[ROWS][COLS];

        for(int r=0;r<ROWS;r++){
            for(int c=0;c<COLS;c++){
                if(dfs(board,word,path,r,c,0))
                return true;
            }
        }
        return false;

    }
    public boolean dfs(char[][] board,String word,boolean[][] path,int r,int c , int i){
        if(i == word.length()){
            return true;
        }
        if(r<0 || c<0 || r>= board.length || c>= board[0].length || word.charAt(i) != board[r][c] || path[r][c]){
            return false;
        }
        path[r][c] =   true;
        boolean res = dfs(board,word,path,r+1,c,i+1) || dfs(board,word,path,r-1,c,i+1) || 
                      dfs(board,word,path,r,c+1,i+1) || dfs(board,word,path,r,c-1,i+1);
        path[r][c] = false;
        return res;       
    }
}
