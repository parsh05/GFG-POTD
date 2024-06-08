//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.numberOfConsecutiveOnes(N));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    static int numberOfConsecutiveOnes(int n) {
        // code here
        if( n < 2) return 0;
        int ans = 1;
        int mod = 1000000007;
        int a = 0;
        int b = 1;
        int c = 1;
        for( int i = 3; i <= n; i++){
            // fibonacci sum
            c = (a + b) % mod;
            ans = ( (ans * 2)%mod + c) % mod;
            a = b;
            b = c;
        }
        return ans;
    }
}
