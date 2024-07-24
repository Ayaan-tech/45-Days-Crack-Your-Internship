import java.util.Stack;

class Solution {
    public int calculate(String s) {
      //Time and Space Complexity:O(N) and O(N)
         Stack<Integer> st = new Stack<>();
        int number = 0;
        char sign = '+';
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            }
            if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
                if (sign == '+') {
                    st.push(number);
                } else if (sign == '-') {
                    st.push(-number);
                } else if (sign == '*') {
                    st.push(st.pop() * number);
                } else if (sign == '/') {
                    st.push(st.pop() / number);
                }
                sign = c;
                number = 0;
            }
        }

        while (!st.isEmpty()) {
            result += st.pop();
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String expression = "3+2*2";
        System.out.println("Result: " + solution.calculate(expression));  // Expected Output: 7
    }
}
