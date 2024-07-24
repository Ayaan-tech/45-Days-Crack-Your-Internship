import java.util.*;

class Solution{
  static int largestArea(int arr[] , int n){
    //Time Complexity : O(n^2 ) and O(1)
      int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int minHeight = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                minHeight = Math.min(minHeight, arr[j]);
                maxArea = Math.max(maxArea, minHeight * (j - i + 1));
            }
        }
        return maxArea;
  }
  static int largestRectangleArea(int[] heights){
    //Stack Data Structure is used for maintaining the widths by poping the greater height from stack and its way efficient than brute force but takes extra space O(n) for stack initialization 
    int n = heights.length;
    Stack<Integer> st = new Stack<>();
    int leftSmall[] = new int[n];
    int rightSmall[] = new int[n];
    for(int i=0;i<n;i++){
      while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
        st.pop();
      }
      if(st.isEmpty()) leftSmall[i] = 0;
      else leftSmall[i] = st.peek() + 1;
      st.push(i);
      
    }
    while(!st.isEmpty ()) st.pop();
    for (int i=n-1;i>=0;i--){
      while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
        st.pop();
      }
      if (st.isEmpty()) rightSmall[i] = n-1;
      else rightSmall[i] = st.peek() -1;
      st.push(i);
    }
    int maxA = 0;
    for (int i=0;i<n;i++){
      maxA = Math.max(maxA, heights[i] * (rightSmall[i] - leftSmall[i] + 1));
    }
    return maxA;
   }
}
