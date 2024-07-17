 static int maxProfitBrute(int[] prices){
        // This  is the Brute force Approach we can think of using Two pointers approach in which
        // we will increment our MaxProfit variable by comparing the profit on buy day and sell day
        //Time Complexity :O(N^2) and O(1)

        int MaxProfit = 0;
        for(int i=0;i<prices.length;i++){
            for (int j=i+1;j<prices.length;j++){
                if (prices[j] > prices[i]){
                    MaxProfit = Math.max(prices[j] - prices[i],MaxProfit);
                }
            }
        }
        return MaxProfit;
    }
    static int maxProfitOptimal( int[] prices){
        // In this approach , we will maintain a minimum from the start of the array and compare it with every element
        // if it's greater than take the difference and store in the max variable otherwise update min
        //Time Complexity : O(N)
        // Space Complexity :O(1)

        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i=0;i < prices.length;i++){
            min = Math.min(min,prices[i]);
            max= Math.max(max,prices[i]-min);
        }
        return max;
    }
