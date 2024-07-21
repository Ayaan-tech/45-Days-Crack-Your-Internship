class Solution{
  public boolean isValid(String s){
    //Just a Simple and efficient use of Stack 
    //Time and Space Complexity :O(N) and O(1)
    Stack<Character> stack = new Stack<>();
    Map<Character,Character> closeToOpen = new HashMap<>();
    closeToOpen(')','(');
    closeToOpen(']','[');
    closeToOpen('}','{');
    for (char c :s.toCharArray){
      if (closeToOpen.containsKey(c)){
        if(!stack.isEmpty() && stack.peek() == closeToOpen.get(c)){
          stack.pop();
        }else{
          return false;
        }
      }else{
        stack.push(c);
      }
    }
    return stack.isEmpty();
  }
}
