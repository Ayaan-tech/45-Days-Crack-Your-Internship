class Solution {
    public List<String> generateParenthesis(int n) {
      //Time and Space Complexity :O(2^n) and O(2^n) as through backtracting Each combination is generated recursively , and there are Cn valid combinations for n pairs of paranthesis
      //For each combinaion , we perform a constant amount of work
        List<String> res = new ArrayList<>();
        backtrack(res, new StringBuilder(),0,0,n);
        return res;
    }
    private void backtrack(List<String> res,StringBuilder current,int openN,int closedN,int n){
        if(openN ==n && closedN ==n){
            res.add(current.toString());
            return;
        }
        if(openN <n){
            current.append('(');
            backtrack(res,current,openN+1,closedN,n);
            current.deleteCharAt(current.length() - 1);
        }
        if (closedN<openN){
            current.append(')');
            backtrack(res,current,openN,closedN + 1,n);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
