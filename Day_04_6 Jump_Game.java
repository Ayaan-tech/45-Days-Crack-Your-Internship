class Solution{
  public boolean canJump(int[] nums) {
    //Time complexity : O(N^2) and Space complexity :O(1) as we are recursively approaching the every near possible approach using Dynamic Programming 
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[n - 1] = true;

        for (int i = n - 2; i >= 0; i--) {
            int farthest = Math.min(i + nums[i], n - 1);
            for (int j = i + 1; j <= farthest; j++) {
                if (dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[0];
    }
  public boolean canJump(int[] nums) {
    //This greedy approach which reversely reduces the search space array by comparing the distance between n-1 and n-2 and the updating our goal
    //Time complexity :O(N) and Space Complexity :O(1)
        int goal = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= goal) {
                goal = i;
            }
        }
        return goal == 0;
    }
}
