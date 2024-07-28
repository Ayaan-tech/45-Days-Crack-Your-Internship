class Solution {
    public List<List<String>> Anagrams(String[] string_list) {
      //Time Complexity :O(K*Nlogn)
      //Space Complexity :O(N)
        int n = string_list.length; // Corrected to use length for array
        List<List<String>> result = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String temp = string_list[i];
            char[] charArray = temp.toCharArray();
            Arrays.sort(charArray);
            String sortedTemp = new String(charArray);
            if (!map.containsKey(sortedTemp)) {
                map.put(sortedTemp, new ArrayList<>());
            }
            map.get(sortedTemp).add(string_list[i]);
        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()) { // Corrected type
            result.add(entry.getValue()); // Corrected to call getValue()
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] string_list = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> groupedAnagrams = solution.Anagrams(string_list);
        for (List<String> group : groupedAnagrams) {
            System.out.println(group);
        }
    }
}
