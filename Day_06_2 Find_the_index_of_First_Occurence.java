class Solution{
  public static int StrStr(String haystack,String needle){
    //Time Complexity :O((N-M+1).M) => O(N*M)
    //Space Complexity :O(1)
    if(needle.length() == 0 ){
      return 0;
    }
    for (int i=0;i<=haystack.length() - needle.length();i++){
      int j;
      for(int j=0;j<needle.length();j++){
        if(haystack.charAt(i+j) != needle.charAt(j)){
          break;
        }
      }
      if(j==needle.length()){
        return i;
      }
    }
    return -1;
  } 
}
