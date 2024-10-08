//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.findPosition(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int findPosition(int N) {
        // code here
        if(N == 0) return -1;
        int pos = 0;
        
            int rmsb = N & -N;
            if(N - rmsb != 0) return -1;
            while(rmsb > 0){
                pos++;
                rmsb = rmsb >> 1;
            }
        return pos;
    }
};