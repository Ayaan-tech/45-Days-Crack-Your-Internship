class Solution {
    public boolean validPalindrome(String s) {
      //Time Complexity :O(N) and Space Complexity :O(1)
        int l =0,r=s.length()-1;
      while(l<r){
        if (s.charAt(l) != s.charAt(r)){
          return isPallindrome(s,l+1,r) || isPallindrome(s,l,r-1);
        }
        l++;
        r--;
      }
      return true;
    }
  public boolean isPallindrome(String s,int l,int r){
    while(l<r){
      if(s.charAt(l) != s.charAt(r)){
        return false;
      }
      l++;
      r--;
    }
    return true;
  }
}
