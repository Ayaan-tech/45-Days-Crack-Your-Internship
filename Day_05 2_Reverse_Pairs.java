class Solution{
  public static int countPairs(int[] arr,int n){
    //Time and Space Complexity Of Brute Force :O(N^2) and O(1)
    int count = 0;
    for(int i=0;i<n;i++){
      for(int j=i+1;j<n;j++){
        if(arr[i] > 2*arr[j])
          count++;
        
      }
    }
    return count;
  }
  static int team(int[] skill , int n){
    int n = nums.length;
    return mergeSort(nums,0,n-1);
  }
  public static int countPairsOptimal(int[] arr,int low,int high,int mid ){
    //Time Complexity : O(2*NlogN) and O(N) space complexity as merge() function takes O(N) times and countPairs takes O(N) times as we are iterating left half once and right half once
    int right = mid+1;
    int cnt =0;
    for(int i=low; i<=mid;i++){
      while(right <= high && arr[i] > 2*arr[right]) right++;
      cnt += (right - (mid +1));
    }
    return cnt;
  }
  private static void merge(int[] arr, int low, int mid, int high){
    ArrayList<Integer> temp = new ArrayList<>();
    int left = low;
    int right = mid + 1;
    while (left <= mid && right <= high){
      if(arr[left] <= arr[right]){
        temp.add(arr[left]);
      }else{
        temp.add(arr[right]);
        right++;
      }
    }
    while(left<= mid){
      temp.add(arr[left]);
      left++;
    }
    while(right<=high){
      temp.add(arr[right]);
      right++;
      
    }
    for(int i = low;i<= high;i++){
      arr[i] = temp.get(i - low);
    }
  }
  public static int mergeSort(int[] arr, int low , int high){
    int cnt =0;
    if(low >= high) return cnt;
    int mid = (low + high)/2;
    cnt += mergeSort(arr,low,mid);
    cnt += mergeSort(arr,mid+1,high);
    cnt+= countPairs(arr,low,mid,high);
    merge(arr,low,mid,high);
    return cnt;
    
  }
}
