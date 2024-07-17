class Solution {
    public void moveZeroes(int[] nums) {
      // Here, I have used two pointer approach to solve this approach
      //Time Complexity : O(N)
      //Space Complexity :O(1)
        int n = nums.length;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }
        for (int i = j; i < n; i++) {
            nums[i] = 0;
        }
}
}
