import java.util.HashMap;

class Solution {
    public String minWindow(String s, String t) {
// Time and Space Complexity :O(N) and O(1)
        if (s.length() < t.length()) {
            return "";
        }

        // Frequency map for characters in t
        HashMap<Character, Integer> pMap = new HashMap<>();
        for (char ch : t.toCharArray()) {
            pMap.put(ch, pMap.getOrDefault(ch, 0) + 1);
        }

        // Sliding window technique
        int start = 0, startIndex = -1, minLength = Integer.MAX_VALUE;
        int count = 0;
        HashMap<Character, Integer> sMap = new HashMap<>();

        for (int end = 0; end < s.length(); end++) {
            char endChar = s.charAt(end);
            sMap.put(endChar, sMap.getOrDefault(endChar, 0) + 1);
            if (pMap.containsKey(endChar) && sMap.get(endChar) <= pMap.get(endChar)) {
                count++;
            }
            while (count == t.length()) {
                char startChar = s.charAt(start);
                int windowLength = end - start + 1;
                if (windowLength < minLength) {
                    minLength = windowLength;
                    startIndex = start;
                }
            
                sMap.put(startChar, sMap.get(startChar) - 1);
                if (pMap.containsKey(startChar) && sMap.get(startChar) < pMap.get(startChar)) {
                    count--;
                }
                start++;
            }
        }

        return (startIndex == -1) ? "" : s.substring(startIndex, startIndex + minLength);
    }
}
