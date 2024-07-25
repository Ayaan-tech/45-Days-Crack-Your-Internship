import java.util.*

class Solution{
  static int maximalRect(char[][] maxtrix){
    //Time Complexity : O(M*N) and Auxiliary Space : O(N)
    if(matrix == null || matrix.length == 0){
      return 0;
    }
    int m = matrix.length;
    int n = matrix[0].length;
    int[] left = new int[n];
    int[] right = new int[n];
    int[] height = new int[n];
    Arrays.fill(right,n);
    int maxArea = 0;
    for (char[] row:matrix){
      int currentLeft = 0, currentRight = n;
      for(int j =0;j<n;j++){
        if(row[j] == '1'){
          height[j]++;
        }else {
          height[j] =0;
        }
      }
      for(int j=0;j<n;j++){
        if(row[j] == '1'){
          left[j] = Math.max(left[j],currentLeft);
        }else{
          left[j] = 0;
          currentLeft = j + 1;
        }
      }
      for (int j = n-1; j>=0; j--){
        if(row[j] == '1'){
          right[j] = Math.min(right[j],currentRight);
        }else{
          right[j] =n;
          currentRight = j;
        }
      }
      for(int j = 0;j < n;j++){
        maxArea = Math.max(maxArea , (right[j] - left[j] ) * height[j]);
      }
    }
    return maxArea;
  }
}
