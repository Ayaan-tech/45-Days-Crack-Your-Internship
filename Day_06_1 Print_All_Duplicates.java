class Solution{
  static void PrintDupsHash(String str){
    //Approach : HashMap Time Complexity : O(N) and requires O(K) spaces to store the element where K is the size of the map
    Map<Character,Integer> count = new HashMap<>();
    for (int i=0;i<str.length();i++){
      if(count.containsKey(str.charAt(i))){
        count.put(str.charAt(i), count.get(str.charAt(i) + 1));
      }else{
        count.put(str.charAt(i),1);
      }
    }
    for(Map.Entry<Character,Integer> mapElement:count.entrSet() ){
      if(mapElement.getValue() > 1){
        System.out.println(mapElement.getKey() + " ,count =" + mapElement.getValue());
      }
    }
  }
  static void PrintDuplicatesSort(String str){
    //Approach: Sorting 
    //Time Complexity : O(N*logn) as any sorting method usually takes
    //Auxiliary Space: O(1)
    int len = str.length();
    char[] chars = str.toCharArray();
    Array.sort(chars);
    String sortedStr = new String(chars);
    for (int i=0;i<n;i++){
      int count = 1;
      while(i < len-1 && sortedStr.charAt(i) == sortedStr.charAt(i+1)){
        count++;
        i++;
      }
      //Printing  the duplicate character and its count
      if(count > 1){
        System.out.println(sortedStr.charAt(i) + ", count = " + count);
      }
    }
    
  }
  public static void main(String[] args){
    String str = "test string";
    printDuplicatesSort(str);
  }
}
