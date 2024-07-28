class Solution {
    private Map<String, Integer> cache = new HashMap<>();
  //Time and Space Complexity : O(M*N) and O(N)
    public int numDistinct(String s, String t) {
        return dfs(s,t,0,0);
    }
    private int dfs(String s, String t,int i, int j){
        if( j == t.length()){
            return 1;
        }
        if(i == s.length()){
            return 0;
        }
        String key = i + "," + j;
        if(cache.containsKey(key)){
            return cache.get(key);
        }
        int result;
        if(s.charAt(i) == t.charAt(j)){
            result = dfs(s,t,i+1,j+1) + dfs(s,t,i+1,j);
        }else {
            result = dfs(s,t,i+1,j);
        }
        cache.put(key,result);
        return result;
    }
    
}
