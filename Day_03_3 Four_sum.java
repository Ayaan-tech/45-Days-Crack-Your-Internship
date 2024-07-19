class Solution{
  static List<List<Integer>> fourSum(int[] nums, int target){
    //BruteForce Approach : Time Complexity : O(N^4) and O(2*number of quadruplets) as we are using a set data structure and a list to store the quads
    int n = nums.length;
    Set<List<Integer>> set = new HashSet<>();
    for (int i=0;i<n;i++){
      for (int j=i+1;j<n;j++){
        for(int k=j+1;k<n;k++){
          for (int l=k+1;l<n;l++){
            long sum = (long)nums[i] + nums[j];
            sum += nums[k];
            sum += nums[l];
            if (sum == target){
              List<Integer> temp = Arrays.asList(nums[i],nums[j],nums[k],nums[l]);
              Collections.sort(temp);
              set.add(temp);
            }
          }
        }
      }
    }
    List<List<Integer>> ans = new ArrayList<>();
    return ans;
  }
  static List<List<Integer>> fourSumOptimal(int[] nums, int target){
    //Time Complexity :O(N^3) and Space is been reduced to O(Number of quadruplets) .The space is used to store the answer O(1)
    int n = nums.length;
     List<List<Integer>> ans = new ArrayList<>();
     Arrays.sort(nums);
    for (int i=0;i<n;i++){
      if(i>0 && nums[i] == nums[i-1]) continue;
      for(int j=i+1;j<n;j++){
        if(j>i+1 && nums[j] == nums[j-1]) continue;
        int k=j+1;
        int l=n-1;
        while(k<l){
          long sum = nums[i];
          sum += nums[j];
          sum += nums[k];
          sum += nums[l];
          if(sum==target){
            List<Integer> temp = new ArrayList<>();
             temp.add(nums[i]);
             temp.add(nums[j]);
             temp.add(nums[k]);
             temp.add(nums[l]);
             ans.add(temp);
             k++;
             l--;
            while(k<l && nums[k] == nums[k-1]) k++;
            while(k<l && nums[l] == nums[l+1]) l--;
          }else if(sum < target) k++;
          else l--;
        }
      }
    }
    return ans;

  }
  
 }
