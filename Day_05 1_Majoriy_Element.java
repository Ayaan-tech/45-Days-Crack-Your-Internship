class Solution{
  public static int majorityElement(int[] v){
    //Time Complexity : O(N^2) 
    //Space Complexity :O(N) Simple Brute Force Approach
    int n = v.length;
    for (int i=0;i<n;i++){
      int cnt =0;
      for(int j=0;j<n;j++){
        if(v[j] == v[i]){
          cnt++;
        }
      }
      if(cnt >(n/2))
        return v[i];
    }
    return -1;
  }
  public static int majorityElementOptimal(int[] v){
    //Time Complexity :O(N)
    //Space Complexity :O(1)
    //Approach : Moore's Voting Algoritm
    int n = v.length;
    int count =0;
    int element = 0;
    for(int i:v){
      if(cnt ==0){
        count =1;
        element = v[i];
      }else if(element == v[i]){
        cnt++;
      }else{
        cnt--;
      }
      //checking if the stored element is the majority element
      int cnt1 =0;
      for (int i=0;i<n;i++){
        if(v[i] == element) cnt1++;
      }
      if(cnt1 >(n/2)) return element;
      return -1;
    }
  }
}
