class Solution {
     public int maxAreaBrute(int[] height) {
       //Brute Force Approach
       //Linear Traversing and finding can also find the solution but in O(N^2) time complexity which is undesirable for the question

        int res = 0;
        for (int l = 0; l < height.length; l++) {
            for (int r = l + 1; r < height.length; r++) {
                int area = (r - l) * Math.min(height[l], height[r]);
                res = Math.max(res, area);
            }
        }
        return res;
    }
    public int maxArea(int[] height) {
      //Optimal Approach : O(N) and O(1) time and space
        int res=0;
        int l=0,r=height.length -1;
        while(l<r){
            int area = (r-l)*Math.min(height[l],height[r]);
            res =Math.max(res,area);
            if(height[l] <height[r]){
                l++;
            }
            else{
                r--;
            }
        }
        return res;
    }
}
