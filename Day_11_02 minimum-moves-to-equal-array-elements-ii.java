class Solution {
    public int minMoves2(int[] nums) {
      //Time Complexity : O(N*logn )
      //Space Complexity :O(1)
        Arrays.sort(nums);
        int operations = 0, mid = nums[nums.length/2];
        for(int num:nums){
        operations += Math.abs(mid - num);
        }
        return operations;
    }
}
