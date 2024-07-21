class Solution {
    public void gameOfLife(int[][] board) {
      //Time Complexity : O(rows x cols) + O(8xrowsxcols) => O(rows x cols)
      //Space Complexity :O(1)
        int rows = board.length;
        int cols = board[0].length;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int neighbors = countNeighbors(board, r, c);
                if (board[r][c] == 1) {
                    if (neighbors < 2 || neighbors > 3) {
                        board[r][c] = 3; 
                    }
                } else if (board[r][c] == 0) {
                    if (neighbors == 3) {
                        board[r][c] = 2;
                    }
                }
            }
        }
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == 1 || board[r][c] == 2) {
                    board[r][c] = 1; 
                } else {
                    board[r][c] = 0; 
                }
            }
        }
    }
    private int countNeighbors(int[][] board, int r, int c) {
        int rows = board.length;
        int cols = board[0].length;
        int neighbors = 0;
        for (int i = r - 1; i <= r + 1; i++) {
            for (int j = c - 1; j <= c + 1; j++) {
                if ((i == r && j == c) || i < 0 || j < 0 || i >= rows || j >= cols) {
                    continue;
                }
                if (board[i][j] == 1 || board[i][j] == 3) {
                    neighbors++;
                }
            }
        }
        return neighbors;
    }
}
