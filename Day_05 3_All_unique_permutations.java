class Solution {
    public static void permutation(int i, int n, ArrayList<Integer> p, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> arr, boolean[] v) {
      //Approach : Backtracking filling the unique spaces . To find unique permutations the formula is: n!/ r!r! where r is the repeated set of number 
      //Time complexity : O(n!*N)
      //Auxiliary Space :O(n!*N)
        if (i == n) {
            ans.add(new ArrayList<>(p));
            return;
        }

        for (int j = 0; j < n; j++) {
            if (!v[j]) {
                if (j > 0) {
                    if (!arr.get(j).equals(arr.get(j - 1)) || v[j - 1]) {
                        p.add(arr.get(j));
                        v[j] = true;
                        permutation(i + 1, n, p, ans, arr, v);
                        v[j] = false;
                        p.remove(p.size() - 1);
                    }
                } else {
                    p.add(arr.get(j));
                    v[j] = true;
                    permutation(i + 1, n, p, ans, arr, v);
                    v[j] = false;
                    p.remove(p.size() - 1);
                }
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr, int n) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> p = new ArrayList<>();
        boolean[] v = new boolean[n];
        Arrays.fill(v, false);
        Collections.sort(arr);
        permutation(0, n, p, ans, arr, v);
        return ans;
    }
};
