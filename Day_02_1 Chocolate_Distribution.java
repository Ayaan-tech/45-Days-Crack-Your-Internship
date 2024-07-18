import java.util.*;
class Solution {
  //Time complexity : O(N*logN) + O(N) => O(N*logN)
  //Space Complexity :O(N) for Sorting using collections and storing a list 
  public long findMinDiff(ArrayList<Integer>,int n, int m){
    long minDiff = Long.MAX_VALUE;
    for(int i=0;i+m-1<n;i++){
      minDiff= Math.min(a.get(i+m-1) - a.get(i), minDiff);
    }
    return minDiff;
  }
  public static void main(String[] args){
    int[] arr = {7,3,2,4,9,12,56};
    int m =3;
    ArrayList<Integer> arraylist = new ArrayList<>();
    for(int num :arr){
      arrayList.add(num);
    }
    Solution ob = new Solution();
    system.out.println("Minimum Difference :" +ob.findMinDiff(arraylist,arraylist.size(),m));
  }
}
