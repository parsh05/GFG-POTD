//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


class Solution {
    private void solve(int[][] mat, int i, int j, String s, ArrayList<String> ans){
        // Base condition
        int n = mat.length;
        if(i == n-1 && j == n - 1){
            ans.add(s);
            return;
        }
        mat[i][j] = -1;  // do 
        // traverse
        if(j > 0 && mat[i][j-1] == 1) solve(mat, i, j-1, s + "L", ans);
        if(i > 0 && mat[i-1][j] == 1) solve(mat, i-1, j, s + "U", ans);
        if(j < n - 1 && mat[i][j+1] == 1) solve(mat, i, j+1, s + "R", ans);
        if(i < n - 1 && mat[i+1][j] == 1) solve(mat, i+1, j, s + "D", ans);
        
        mat[i][j] = 1; // undo
    }
    public ArrayList<String> findPath(int[][] mat) {
        // Your code here
        ArrayList<String> ans = new ArrayList<>();
        if(mat[0][0] == 1) solve(mat, 0, 0, "", ans);
        return ans;
    }
}