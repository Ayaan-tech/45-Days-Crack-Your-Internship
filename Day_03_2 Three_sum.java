import java.util.*;
class Solution{
  public static List<List<Integer>> tripletBrute(int n,int[] arr){
    //Brute Force Approach : As traversing through each for loops for satisfying the condition for all to add upto zero might take O(N^3) time complexity
// And O(2*number of unique tuplets) => O(2*N) . The interviewer might not be happy with this solution. So below is the Optimal solution
    Set<List<Integer>> st = new HashSet<>();
    for(int i=0;i<n;i++){
      for(int j=i+1;j<n;j++){
        for(int k=j+1;k<n;k++){
          if(arr[i] + arr[j] + arr[k] == 0){
            List<Integer> temp = Arrays.asList(arr[i],arr[j],arr[k]);
            temp.sort(null);
            st.add(temp);
          }
        }
      }
    }
    List<List<Integer>> ans = new ArrayList<>();
    return ans;
  }
  public static List<List<Integer>> tripletOptimal(int n, int[] arr){
    //Optimal Approach :
    //Time Complexity : O(NlogN) + O(N^2)
    //Space Complexity : O(1) as O(number of quadruplets ) . This space is only  used to store the answer . We are not using any extra space for storing 
    List<List<Integer>> ans = new ArrayList<>();
    for(int i=0;i<n;i++){
      if(i!=0 && arr[i] == arr[i-1]) continue;
      int j = i+1;
      int k=n-1;
      while(j<k){
        int sum = arr[i] + arr[j] + arr[k];
        if(sum <0){
          j++;
          
        }
        else if(sum>0){
          k--;
        }else{
          List<Integer> temp = Arrays.asList(arr[i],arr[j],arr[k]);
          ans.add(temp);
          j++;
          k--;
          while(j<k && arr[j] == arr[j-1]) j++;
          while (j<k && arr[k] == arr[k+1]) k--;
        }
      }
    }
    return ans;
  
  }
}
