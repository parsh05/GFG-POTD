//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.padovanSequence(n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
  public int padovanSequence(int n)
    {
        //code here.
    if(n < 3) return 1;
    long mod = 1000000007;
       int fn = 0, fn1 = 1, fn2 = 1, fn3 = 1;
       for(int i = 3; i <= n; i++){
           fn = (int) (( fn2 + fn3) % mod);
           fn3 = fn2;
           fn2 = fn1;
           fn1 = fn;
       }
       return fn;
    }
    
}
