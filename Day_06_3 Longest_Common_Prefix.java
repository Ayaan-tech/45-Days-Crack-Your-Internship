class Solution {
    public String longestCommonPrefix(String[] strs) {
      //Time Complexity : O(N x L) => where L is the length of the first string and N is the number of strings in the array
      //Space Complexity :O(N)
        if(strs == null || strs.length == 0 ){  
            return "";
        }
        StringBuilder res = new StringBuilder();
        for (int i=0;i<strs[0].length();i++){
            char c = strs[0].charAt(i);
            for(String s:strs){
                if (i== s.length() || s.charAt(i) != c){
                    return res.toString();
                }
            }
            res.append(c);
        }
        return res.toString();
    }
}
