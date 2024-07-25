class Solution {
    public boolean isNumber(String s) {
      //Time and Space Complexity :O(N) and O(1) respectively
        boolean decimalUsed = false;
        boolean numberSeen = false;
        boolean eSeen = false;
        int i = 0;

        while (i < s.length() && Character.isWhitespace(s.charAt(i))) {
            i++;
        }

       
        if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            i++;
        }

        while (i < s.length()) {
            char curChar = s.charAt(i);

            if (Character.isDigit(curChar)) {
                numberSeen = true;
            } else if (curChar == '.') {
                if (decimalUsed || eSeen) {
                    return false;
                }
                decimalUsed = true;
            } else if (curChar == 'e' || curChar == 'E') {
                if (eSeen || !numberSeen) {
                    return false;
                }
                eSeen = true;
                numberSeen = false; 
            } else if (curChar == '+' || curChar == '-') {
                
                if (i == 0 || !(s.charAt(i - 1) == 'e' || s.charAt(i - 1) == 'E')) {
                    return false;
                }
            } else {
                return false;
            }
            i++;
        }

      
        while (i < s.length() && Character.isWhitespace(s.charAt(i))) {
            i++;
        }

        return numberSeen && i == s.length();
    }

  
}
