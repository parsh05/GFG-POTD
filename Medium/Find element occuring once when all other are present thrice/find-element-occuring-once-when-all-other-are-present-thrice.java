//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            int[] arr = new int[N];
            
            for(int i=0 ; i<N ; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.singleElement(arr,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int singleElement(int[] arr , int n) {
        // code here
        int tn = -1 , tn1 = 0 , tn2 = 0 ;
        for(int i=0;i<arr.length;i++){
            int cwtn = arr[i] & tn;
            int cwtn1 = arr[i] & tn1 ;
            int cwtn2 = arr[i] & tn2;
            
            tn = (tn & (~cwtn));
            tn1 = (tn1 | cwtn);
            
            tn1 = (tn1 & (~cwtn1));
            tn2 = (tn2 | cwtn1);
            
            tn2 = (tn2 & (~cwtn2));
            tn = (tn | cwtn2);
        }
        return tn1;
    }
}