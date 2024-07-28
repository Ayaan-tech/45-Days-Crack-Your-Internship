class Solution {
    public String convertToTitle(int columnNumber) {
        //Time and Space Complexity :O(log26(columNumber)) 

        StringBuilder result = new StringBuilder();
        while(columnNumber > 0){
            columnNumber--;
            int remain = columnNumber%26;
            result.append((char)(remain + 'A'));
            columnNumber = (columnNumber) /26;
        }
        return result.reverse().toString();
    }
}
