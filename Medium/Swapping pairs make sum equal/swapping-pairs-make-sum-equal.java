//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    long findSwapValues(long a[], int n, long b[], int m) {
        // Your code goes here
        Arrays.sort(a);
        Arrays.sort(b);
        long sum_a = 0, sum_b = 0;
        for( long num : a) sum_a += num;
        for( long num : b ) sum_b += num;
        int i = 0, j = 0;
        if( sum_a > sum_b ){
            while( i < n && j < m){
            long diff = a[i] - b[j] ;
            if( sum_a - diff == sum_b + diff ) return 1;
            else if(sum_a - diff > sum_b + diff )j++;
            else i++;
            }   
        } else{
            while( i < n && j < m){
            long diff = a[i] - b[j] ;
            if( sum_a - diff == sum_b + diff ) return 1;
            else if(sum_a - diff < sum_b + diff )j++;
            else i++;
            }
        }
        
        return -1;
    
    }
}


//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n = Integer.parseInt(q[0]);
            int m = Integer.parseInt(q[1]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(a1[i]);
            }
            String line2 = br.readLine();
            String[] a2 = line2.trim().split("\\s+");
            long b[] = new long[m];
            for (int i = 0; i < m; i++) {
                b[i] = Long.parseLong(a2[i]);
            }
            Solution ob = new Solution();
            long ans = ob.findSwapValues(a, n, b, m);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends