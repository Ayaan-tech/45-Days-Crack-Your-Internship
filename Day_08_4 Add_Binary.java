class Solution {
    public String addBinary(String a, String b) {
      //Time Complexity : O(N) and Space Complexity :O(N) as StringBuider will require N space for at worst for longer strings
        StringBuilder sb = new StringBuilder();
        int i = a.length()-1;
        int j = b.length() - 1;
        int carry = 0;
        while( i >=0 || j >=0){
            int sum =  carry;
            if(i >=0) sum += a.charAt(i) -'0';
            if(j>=0) sum += b.charAt(j) -'0';
            sb.append(sum %2);
            carry = sum / 2;
            i--;
            j--;
        }
        if(carry != 0 ) sb.append(carry);
        return sb.reverse().toString();
    }
}
