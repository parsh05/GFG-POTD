//{ Driver Code Starts
// Initial Template for java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            int k = Integer.parseInt(S[2]);
            int mat[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                String S1[] = read.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    mat[i][j] = Integer.parseInt(S1[j]);
                }
            }
            Solution ob = new Solution();
            int ans[][] = ob.rotateMatrix(k, mat);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) System.out.print(ans[i][j] + " ");
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


// User function template for java

class Solution {
    int[][] rotateMatrix(int k, int matrix[][]) {
        // code here
        int n = matrix.length, m = matrix[0].length;
        k = k % m;
        for(int i = 0; i <n ; i++){
            int l = 0;
            Queue<Integer> q =new LinkedList<>();
            for(int j = 0; j < m; j++){
                if(j < k ) q.add(matrix[i][j]);
                else matrix[i][l++] = matrix[i][j];
            }
            while(q.size() > 0 ){
                matrix[i][l++] = q.poll();
            }
        }
        return matrix;
    }
}