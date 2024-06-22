//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.regex.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.ExtractNumber(S));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    long ExtractNumber(String sentence) {
        // code here
        long ans = -1;
        String[] arr = sentence.split(" ");
        for( String s : arr){
            if(s.charAt(0) >= '0' && s.charAt(0) < '9' && s.contains("9") == false ) {
                long curr = Long.parseLong(s);
                ans = Math.max(ans, curr);
            }
        }
        return ans;
    }
}