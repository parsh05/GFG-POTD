//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine();
            String[] S = s.split(" ");
            int[] v = new int[2 * n + 2];
            for(int i = 0; i < 2 * n + 2; i++)
            {
                v[i] = Integer.parseInt(S[i]);
            }
            Solution ob = new Solution();
            int[] ans = ob.singleNumber(v);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int[] singleNumber(int[] nums)
    {
        // Code here
        int xxory = 0;
        for(int n : nums) xxory = xxory ^ n;
        
        int rmsb = (xxory & (-xxory) ) ;
        
        // rmsb par jaakar do alag alag set rkhte hai
        int setA = 0 , setB=0;
        for(int n : nums){
            if( (n & rmsb) == 0) setA = setA ^ n;
            else setB = setB ^ n;
        }
        int[] ans = new int[2];
        ans[0] = Math.min(setA , setB );
        ans[1] = Math.max(setA , setB );
        return ans;
    }
}