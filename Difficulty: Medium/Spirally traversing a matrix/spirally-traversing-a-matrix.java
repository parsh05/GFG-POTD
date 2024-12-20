//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int r = sc.nextInt();
            int c = sc.nextInt();

            int matrix[][] = new int[r][c];

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends



class Solution {
    // Function to return a list of integers denoting spiral traversal of matrix.
    

    public ArrayList<Integer> spirallyTraverse(int matrix[][]) {
        ArrayList<Integer> ans = new ArrayList<>();
        int l = 0, r = matrix[0].length - 1, t = 0, d = matrix.length - 1;
        int i = 0, j = 0;
        while( l <= r && t <= d){
            for(j = l; j <= r; j++) ans.add( matrix[t][j] );
            t++;
            if( t > d) break;
            for(i = t;i <= d; i++) ans.add( matrix[i][r] );
            r--;
            if( r < l) break;
            for(j = r; j >= l; j--) ans.add( matrix[d][j]);
            d--;
            if( t > d) break;
            for(i = d;  i >= t; i--) ans.add( matrix[i][l] );
            l++;
            if( r < l) break;
        }
        return ans;
    }
}

