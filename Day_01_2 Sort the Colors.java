import java.util.*;
public class Sort_the_colors {
    //As a Better Approach we can always think for use of a sorting algorithm like bucket sort , quicksort . Here I have
    //used quicksort to sort the given Colors array
    //Time Complexity : O(nlogn) for natural best and average cases and O(n^2) for worst of them
    //Space Complexity : Auxiliary Space :O(1) and for recursive call stack :O(logn) or O(n)
    // i.e it might be a solution but not best of them

    static int quicksort(int[] nums, int low, int high){
        if (low < high){
            int pi = partition(nums,low,high);
            quicksort(nums,low,pi-1);
            quicksort(nums,pi+1,high);
        }
        return quicksort(nums,0, nums.length-1) ;
    }
    static int partition(int[] nums,int low,int high){
        int pivot = nums[high];
        int i = low-1;
        for (int j=low;j<high;j++){
            if (nums[j]<=pivot){
                i++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        int temp = nums[i+1];
        nums[i+1] = nums[high];
        nums[high] = temp;
        return i+1;
    }


    static void sortColorsOptimal(int[] nums){
        //In This approach , I have make use of Dutch National Flag Algorithm for its sorting in one pass with no extra
        //space required
        //Time and Space Complexity : O(N) and O(1)

        int low=0,mid= 0,high= nums.length-1;
        while(mid<=high){
            switch (nums[mid]){
                case 0:
                    int tempZ = nums[low];
                    nums[low] = nums[mid];
                    nums[mid] = tempZ;
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                case 2:
                    int temp2 = nums[mid];
                    nums[mid] = nums[high];
                    nums[high] = temp2;
                    high--;
                    break;
            }
        }


    }

    public static void main(String[] args) {
        int[] nums1 = {2,0,2,1,1,0};
        sortColorsOptimal(nums1);
        System.out.println(Arrays.toString(nums1));
        Sort_the_colors.sortColorsOptimal(nums1);
        System.out.println(Arrays.toString(nums1));

    }

}
