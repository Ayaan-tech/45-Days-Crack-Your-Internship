class Solution{
  static boolean(int a[] , int b[] , int n , int k){
  //Time complexity : O(N*logn)
  //Space Complexity : O(1)
  Arrays.sort(a,Collections.reverseOrder());
  Arrays.sort(b);
  for(int i= 0;i<n;i++){
    if(a[i] + b[i] < k){
      return false;
    }
    
  }
  return true;
  }
public static void main(String[] args){
  int a[] = {2,1,3};
  int b[] = {7,8,9};
  int k = 10;
  int n = a.length;
  if(isPossible(a,b,n,k))
    System.out.println("Yes");
  else
    System.out.println("No");
}
}
