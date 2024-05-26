//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String X = sc.next();
            String Y = sc.next();
            int costX = sc.nextInt();
            int costY = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.findMinCost(X, Y, costX, costY));
        }
    }
}
// } Driver Code Ends


class Solution {
    int cX,cY;
    
    private int solve( String x, int i, String y, int j, int[][] dp ){
        if( i < 0 && j < 0) return 0;
       if(i < 0){
           return ( j+1 ) * cY;
       } 
       if( j < 0 ) return (i+1) * cX ;
        
        if( dp[i][j] != -1 ) return dp[i][j];
        if(x.charAt(i) == y.charAt(j) ) {
          dp[i][j] =   solve ( x, i-1, y, j-1,dp );
        } else{
           dp[i][j] =  Math.min( cX + solve(x,i-1,y,j , dp) , cY + solve(x, i, y, j-1 , dp) );
        }
        return dp[i][j];
    }
    
    public int findMinCost(String x, String y, int costX, int costY) {
        cX = costX;
        cY = costY;
        int n = x.length(), m = y.length();
        int[][] dp = new int[n][m];
        for( int[] row : dp ) Arrays.fill( row, -1);
        return solve( x, n-1, y, m-1, dp );
    }
}
