class Solution {
 //Time Complexity: O(N) and Space Complexity : O(1) 
    public static String smallestWindow(String s, String p) {
      
        if (s.length() < p.length()) {
            return "-1";
        }

        HashMap<Character, Integer> pMap = new HashMap<>();
        for (char ch : p.toCharArray()) {
            pMap.put(ch, pMap.getOrDefault(ch, 0) + 1);
        }

        
        int start = 0, startIndex = -1, minLength = Integer.MAX_VALUE;
        int count = 0;
        HashMap<Character, Integer> sMap = new HashMap<>();

        for (int end = 0; end < s.length(); end++) {
            char endChar = s.charAt(end);
            sMap.put(endChar, sMap.getOrDefault(endChar, 0) + 1);

            if (pMap.containsKey(endChar) && sMap.get(endChar) <= pMap.get(endChar)) {
                count++;
            }

            while (count == p.length()) {
                char startChar = s.charAt(start);
                if (!pMap.containsKey(startChar) || sMap.getOrDefault(startChar, 0) > pMap.get(startChar)) {
                    if (pMap.containsKey(startChar) && sMap.getOrDefault(startChar, 0) > pMap.get(startChar)) {
                        sMap.put(startChar, sMap.get(startChar) - 1);
                    }
                    start++;
                } else {
                    break;
                }
            }

            if (count == p.length()) {
                int windowLength = end - start + 1;
                if (minLength > windowLength) {
                    minLength = windowLength;
                    startIndex = start;
                }
            }
        }

        return (startIndex == -1) ? "-1" : s.substring(startIndex, startIndex + minLength);
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(smallestWindow("timetopractice", "toc")); // Output: "toprac"
        System.out.println(smallestWindow("zoomlazapzo", "oza"));    // Output: "apzo"
    }
}
