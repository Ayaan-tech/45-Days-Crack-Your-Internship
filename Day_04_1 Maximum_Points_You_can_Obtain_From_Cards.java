class Solution {
    public int maxScore(int[] cardPoints, int k) {
      // Sliding Window Approach with pointers either sliding from left or right
      //Time Complexity and Space:O(K) and O(1)
     int n = cardPoints.length;
        int lsum = 0, rSum = 0, maxSum = 0;
        for (int i = 0; i < k; i++) {
            lsum += cardPoints[i];
        }
        maxSum = lsum;
        for (int i = 0; i < k; i++) {
            lsum -= cardPoints[k - 1 - i];
            rSum += cardPoints[n - 1 - i];
            maxSum = Math.max(maxSum, lsum + rSum);
        }
        
        return maxSum;
    }
}



