class Solution {
    public String intToRoman(int num) {
      //Time Complexity :O(num) and Space Complexity :O(num)
        Map<Integer,String> symMap = new LinkedHashMap<>();
        symMap.put(1000, "M");
        symMap.put(900, "CM");
        symMap.put(500, "D");
        symMap.put(400, "CD");
        symMap.put(100, "C");
        symMap.put(90, "XC");
        symMap.put(50, "L");
        symMap.put(40, "XL");
        symMap.put(10, "X");
        symMap.put(9, "IX");
        symMap.put(5, "V");
        symMap.put(4, "IV");
        symMap.put(1, "I"); 
        StringBuilder res = new StringBuilder();
        // Iterate through the map in reverse order (LinkedHashMap maintains insertion order)
        for(Map.Entry<Integer,String> entry:symMap.entrySet()){
            int val = entry.getKey();
            String sym = entry.getValue();
            while(num>=val){
                res.append(sym);
                num -= val;
            }
        }
        return res.toString();
    }
}
