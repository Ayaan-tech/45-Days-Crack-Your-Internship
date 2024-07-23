class Solution {
    public String reverseWords(String s) {
        //Time and Space Complexity:O(N) and O(1)
      String[] words = s.trim().split(" ");
      StringBuilder sb = new StringBuilder();
      for (int i= words.length-1;i>=0;i--){
        if(words[i].length() >0){
            sb.append(words[i]);
            sb.append(' ');
        }
      } 
      return sb.substring(0, sb.length() -1).toString();
    }
}
