class Solution{{
  public static int findtheSubarrayBrute(int arr[] , int k){
    //Brute force : O(N^3) Time complexity and O(1) space complexity as we are not using any extra space
    int n = arr.length;
    int cnt =0;
    for(int i=0;i<n;i++){
      for (int j=i;j<n;j++){
        //Caculate the sum of subarray [i....j]
        int sum =0;
        for (int K=i;K<=j;K++){
          sum += arr[K];
        }
         if(sum == k){
            cnt++;
        }  
      }
    }
    return cnt;
  }
  static int findtheSubArrayOptimal(int k,int arr[]){
    //Approch : Prefix sum with the help of Hashmap 
    //Time Complexity : O(N) 
    //Space Complexity :O(1) as unorderd map is used by default with hashmap
    int n = arr.length;
    Map map = new HashMap();
    int preSum = 0,cnt=0;
    map.put(0,1);
    for(int i=0;i<n;i++){
      preSum += arr[i];
      int remove = preSum -k;
      cnt += map.getOrDefault(remove,0);
      map.put(preSum,map.getOrDefault(preSum,0)+1);
    }
    return cnt;
  }
}
