import java.util.*;
class Solution {
    public static void setZeroes(int[][] matrix) {
      //Time Complexity : O(2*(N*M))
      //Space Complexity : O(1)
        int n = matrix.length;
        int m = matrix[0].length;
        boolean col0 = false; 
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 0) {
                col0 = true;
            }
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Use marks to set elements to zero
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (matrix[0][0] == 0) {
            for (int j = 0; j < m; j++) {
                matrix[0][j] = 0;
            }
        }
        if (col0) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {  {1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        System.out.println("Original matrix:");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }

        setZeroes(matrix);

        System.out.println("The Final matrix is: ");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
