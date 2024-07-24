  import java.util.*;
class Solution{
  //Time Complexity  :O(N) and Space Complexity :O(1)
  static int dp[][] = new int[505][2005];
  static int rec(int i, int rem, List<Integer> arr,int k){
    if(i == arr.size()){
      return 0;
    }
    if (dp[i][rem] != 0)
      return dp[i][rem];
    int ans;
    if(arr.get(i) > rem){
      ans = (rem + 1)*(rem + 1) + rec(i+1,k - arr.get(i) - 1 ,arr,k);
    }else{
      int choice1 = (rem+1)*(rem+1) + rec(i+1,k - arr.get(i) - 1, arr,k);
      int choice2 = rec(i+1, rem - arr.get(i) -1, arr,k);
      ans = Math.min(choice1, choice2);
    }
    dp[i][rem] = ans;
    return dp[i][rem];
  }
  static int solveWordWrap(List<Integer> arr,int k){
    for (int[] row:dp){
      Arrays.fill(row, -1);
    }
    return rec(0,k,arr,k);
  }
}
