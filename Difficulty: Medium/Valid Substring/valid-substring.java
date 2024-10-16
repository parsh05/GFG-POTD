//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.findMaxLen(S));
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    static int findMaxLen(String S) {
        int n = S.length();
        int open = 0, close = 0, maxLen = 0;
        
        // First pass (left to right)
        for (int i = 0; i < n; i++) {
            if (S.charAt(i) == '(') open++;
            else close++;
            
            if (open == close) {
                // Valid substring
                maxLen = Math.max(maxLen, 2 * close);
            } else if (close > open) {
                // Invalid, reset
                open = close = 0;
            }
        }
        
        // Second pass (right to left)
        open = close = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (S.charAt(i) == ')') close++;
            else open++;
            
            if (open == close) {
                // Valid substring
                maxLen = Math.max(maxLen, 2 * open);
            } else if (open > close) {
                // Invalid, reset
                open = close = 0;
            }
        }
        
        return maxLen;
    }
}
