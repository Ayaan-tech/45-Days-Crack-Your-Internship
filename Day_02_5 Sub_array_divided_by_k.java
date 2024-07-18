class Solution {
  public int subarraysDivByK(int[] nums, int k) {
    //Time Complexity : O(N)
    //Space Complexity : O(k)
        int prefixSum = 0;
        int result = 0;
        HashMap<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0,1);

        for (int n : nums) {
            prefixSum += n;
            int remainder = (prefixSum % k + k)%k;
           
            if (prefixCount.containsKey(remainder)) {
                result += prefixCount.get(remainder);
            }
            prefixCount.put(remainder, prefixCount.getOrDefault(remainder, 0) + 1);
        }

        return result;
    }
  public static void main(String[] args){
    int[] nums = {4,5,0,-2,-3,1};
    int k = 5;
    int ans = subarraysDivByK(nums,k);
    System.out.println("Number of subarrays divisible by k: " +ans);
  }
}
