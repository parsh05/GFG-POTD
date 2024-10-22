//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if (ans.size() == 0)
                System.out.println("-1");
            else {
                for (int i = 0; i < ans.size(); i++) {
                    System.out.print("[");
                    for (int j = 0; j < ans.get(i).size(); j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java


class Solution {
    HashSet<Integer> diagUp = new HashSet<>();
    HashSet<Integer> diagDown = new HashSet<>();
    HashSet<Integer> col = new HashSet<>();
    
    private void solve(int n, int i, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> result) {
        if (i == n) {
            result.add(new ArrayList<>(curr)); // Add the valid arrangement
            return;
        }
        
        for (int j = 0; j < n; j++) { // Loop through columns
            if (diagUp.contains(i + j) || diagDown.contains(i - j) || col.contains(j)) {
                continue; // Skip if the position is attacked
            }
            // Place the queen
            curr.add(j + 1); // Store 1-based index
            diagUp.add(i + j);
            diagDown.add(i - j);
            col.add(j);

            // Recurse to place queens in the next row
            solve(n, i + 1, curr, result);

            // Backtrack
            curr.remove(curr.size() - 1);
            diagUp.remove(i + j);
            diagDown.remove(i - j);
            col.remove(j);
        }
    }

    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        solve(n, 0, new ArrayList<>(), result); // Start solving from the first row
        return result;
    }
}
