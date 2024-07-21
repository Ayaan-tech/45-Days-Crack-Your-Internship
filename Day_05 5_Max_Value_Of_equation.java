class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        Deque<int[]> deque = new LinkedList<>();
        //Time Complexity : O(N) and O(N)
        deque.offerLast(new int[] {points[0][0],points[0][1] - points[0][0]});
        int n= points.length;
        int maxVal = Integer.MIN_VALUE;
        for (int j=1;j<n;j++){
            while(!deque.isEmpty() && points[j][0] - deque.peekFirst()[0] > k){
                deque.pollFirst();
            }
            if(!deque.isEmpty()){
                int val =  deque.peekFirst()[1] + points[j][1] + points[j][0];
                maxVal = Math.max(maxVal,val);
            }
            int v = points[j][1] - points[j][0];
            while(!deque.isEmpty() && deque.peekFirst()[1] <= v){
                deque.pollFirst();
            }
            deque.offerLast(new int[] {points[j][0], v});
        }
        return maxVal;
    }
}
