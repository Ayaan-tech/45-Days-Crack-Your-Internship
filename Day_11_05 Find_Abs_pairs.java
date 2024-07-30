class Solution{
  public int findPair(int arr[] , int n , int x){
    //Time Complexity :O(N*LogN) 
    //Space Complexity : O(1)
    Arrays.sort(arr);
    int i =0, j =1;
    while(i < n && j < n){
      int diff = arr[j] - arr[i];
      if(diff == x && i!=j){
        return 1;
      }else if(diff < x){
        j++;
      }else{
        i++;
      }
    }
    return -1;
  }
}
