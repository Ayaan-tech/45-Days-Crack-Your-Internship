import java.util.*;
public class Find_the_Duplicate_number {
    static int findDuplicateBetter(int[] nums){
        //This Hashset might be our first approach for finding the solution but it requires and O(n) extra space
        //to keep track of Numbers we have already seen. So it's not the Optimal Approach
        //Time Complexity :O(N) and Space Complexity :O(1)
        Set<Integer> seen = new HashSet<>();
        for (int num:nums){
            if (seen.contains(num)){
                return num;
            }
            seen.add(num);

        }
        return -1;
    }
    static int findDuplicateOptimal(int[] nums){
        //In this approach , we can use the Concept of Floyd's Cycle detection algorithm. It's Efficient and also
        //doesn't require any extra
        //Time complexity:O(N) and Space Complexity :O(1)
        int slow = nums[0];
        int fast = nums[0];
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while (slow != fast);
        slow = nums[0];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        int ans  = findDuplicateOptimal(nums);//findDuplicateBetter(nums)
        System.out.println("The Duplicate number is  : " +ans);
    }

}
