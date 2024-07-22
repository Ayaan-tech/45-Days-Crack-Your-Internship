public class RandomizedCollection {
  // One of the hardest problem I ever faced in my life and took lots of effort to understand and trying to code it.
  //Overall Time and Space : O(1) and O(N) respectively
  
    ArrayList<Integer> nums;
	HashMap<Integer, Set<Integer>> locs;
	java.util.Random rand = new java.util.Random();
    public RandomizedCollection() {
        nums = new ArrayList<Integer>();
	    locs = new HashMap<Integer, Set<Integer>>();
    }
    
    public boolean insert(int val) {
        boolean contain = locs.containsKey(val);
	    if ( ! contain ) locs.put( val, new LinkedHashSet<Integer>() ); 
	    locs.get(val).add(nums.size());        
	    nums.add(val);
	    return ! contain ;
    }
    public boolean remove(int val) {
        boolean contain = locs.containsKey(val);
	    if ( ! contain ) return false;
	    int loc = locs.get(val).iterator().next();
	    locs.get(val).remove(loc);
	    if (loc < nums.size() - 1 ) {
	       int lastone = nums.get( nums.size()-1 );
	       nums.set( loc , lastone );
	       locs.get(lastone).remove( nums.size()-1);
	       locs.get(lastone).add(loc);
	    }
	    nums.remove(nums.size() - 1);
	   
	    if (locs.get(val).isEmpty()) locs.remove(val);
	    return true;
    }
    public int getRandom() {
        return nums.get( rand.nextInt(nums.size()) );
    }
}
