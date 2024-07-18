class Solution {
    public int maxProfit(int[] prices) {
      //Time and complexity :O(N) and O(1)
      //The above problem can also be solved using fractional Knapsack or 0/1 (my personal favourite) but for decrease in time complexity
      // and according to my comfort , I have used greedy here
        int prof = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i] > prices[i-1]){
                prof += prices[i] - prices[i-1];
            }
        }
        return prof;
    }
  public static void main(String[] args){
    int prices[] = {7,1,5,3,6,4};
    int ans = maxProfit(prices);
    System.out.println("Maximum Profit is : " +ans)
  }
}
