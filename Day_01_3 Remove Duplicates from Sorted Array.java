import java.util.*;
public class RemoveDuplicates {
    static int removeDuplicatesBrute(int[] arr){
        //In this approach, we will be using a Simple Hashset for storing unique values of the array
        // and then returning the set of array from start
        //Time Complexity : O(n*logn) + O(n)
        //Space Complexity : O(n)
        HashSet<Integer> set = new HashSet<>();
        for (int i=0;i <arr.length; i++){
            set.add(arr[i]);
        }
        int k = set.size();
        int j=0;
        for (int x:set)
            arr[j++] = x;
        return k;
    }
    static int removeDuplicatesOptimal(int[] nums){
        // This is a 2 Pointer Approach which is more efficient for finding the removing the duplicates
        //and placing them in sort in one pass and doesn't require any extra space
        //Time Complexity: O(N)
        //Space Complexity :O(1)
        int i=0;
        for (int j=1;j<nums.length;j++){
            if (nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }

    public static void main(String[] args) {
        int arr[] = {1,1,2,2,2,3,3};
        int k = removeDuplicatesOptimal(arr);
        int m = removeDuplicatesBrute(arr);
        System.out.println("The array after removing the Duplicates are :");
        for (int i=0;i<m;i++){
            System.out.println(arr[i] + "");
        }
    }
