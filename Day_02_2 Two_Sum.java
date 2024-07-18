package FourtyFiveDays.DayTwo;

import java.util.HashMap;

public class TwoSum {
    static int[] twoSumBrute(int n, int[]arr,int target){
        //Here we have used a simple Linear traversing approach to find the both element indices
        //Time Complexity : O(N^2)
        //Space Complexity :O(1)
        int[] ans= new int[2];
        ans[0] = ans[1] = -1;
        for (int i=0;i<n;i++){
            for (int j=i+1;j<n;j++){
                if (arr[i] + arr[j] == target){
                    ans[0] = i;
                    ans[0] = j;
                    return ans;
                }
            }
        }
        return ans;
    }
    static int[] twoSumOptimal(int n , int[] arr,int target){
        //Time Complexity : O(N)
        //Space Complexity :O(N)
        // Here we have used map data structure for storing the key value pairs of the ans and returning the indices of the 
        // ans if found
        int[] ans = new int[2];
        ans[0] = ans[1] = -1;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<n;i++){
            int num = arr[i];
            int x = target - num;
            if (map.containsKey(x)){
                ans[0] = map.get(x);
                ans[1] = i;
                return ans;
            }
            map.put(arr[i] , i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int n =5;
        int[] arr = {2,6,5,8,11};
        int target = 14;
        int[] ans = twoSumOptimal(n,arr,target);
        System.out.println("The Answer for 2 Sum is :[" +ans[0] + "," + ans[1] + "]" );
    }
}
