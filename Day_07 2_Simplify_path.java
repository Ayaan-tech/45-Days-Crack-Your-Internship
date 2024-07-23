class Solution {
   public String simplifyPath(String path) {
     //Time and Space Complexity : O(N) and O(1) needs for pop operation during a stack and O(n) space and the maximum number of parts is proportional to it
        Deque<String> stack = new ArrayDeque<>();
        StringBuilder cur = new StringBuilder();
        
        for (char c : (path + '/').toCharArray()) {
            if (c == '/') {
                if (cur.toString().equals("..")) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else if (!cur.toString().isEmpty() && !cur.toString().equals(".")) {
                    stack.push(cur.toString());
                }
                cur.setLength(0);
            } else {
                cur.append(c);
            }
        }
        
        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.insert(0, "/" + dir);
        }
        
        return result.length() > 0 ? result.toString() : "/";
    }
}
