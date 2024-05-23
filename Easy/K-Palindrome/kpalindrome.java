//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String input_line[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(input_line[0]);
            int k = Integer.parseInt(input_line[1]);
            String str = in.readLine();

            Solution ob = new Solution();
            System.out.println(ob.kPalindrome(str, n, k));
        }
    }
}
// } Driver Code Ends


class Solution {
    public int kPalindrome(String str, int n, int k) {
        // code here
        int minCharToRemove = n - lps(str,n);
        if( minCharToRemove <= k) return 1;
        else return 0;
    }
    private int lps(String a,int n){
        String b = new StringBuilder(a).reverse().toString();
        return lcs( a , a.length() , b , b.length() );
    }
   
    private int lcs(String a,int A, String b,int B){
        int[][] dp = new int[A+1][B+1];
        for(int i = 0 ;i <= A; i++ ){
            for( int j = 0; j <= B ; j++){
                if( i == 0 || j == 0 ) dp[i][j] = 0;
                else dp[i][j] = -1 ;
            }
        }
        
        for(int i = 1 ;i <= A; i++ ){
            for( int j = 1; j <= B ; j++){
                if(a.charAt(i-1) == b.charAt(j-1) ){
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max ( dp[i-1][j] , dp[i][j-1] );
                }
            }
        }
        return dp[A][B];
    }
}