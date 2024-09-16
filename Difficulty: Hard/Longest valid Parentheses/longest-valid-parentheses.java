//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.maxLength(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java



//User function Template for Java

class Solution{
    static int maxLength(String S){
        // code here
        int left = 0, right = 0;
        int ans = 0;
        for(int i = 0; i < S.length(); i++){
            if(S.charAt(i) == '(' ) left++;
            else if(S.charAt(i) == ')') right++;
            
            if(left == right){
                ans = Math.max(ans, 2 * left);
            } 
            if(left < right){
                left = right = 0;
            }
        }
        left =0;
        right =0;
        
        for(int i = S.length() - 1; i >= 0; i--){
            if(S.charAt(i) == '(' ) left++;
            else if(S.charAt(i) == ')') right++;
            
            if(left == right){
                ans = Math.max(ans,  2 * left);
            }
            if(left > right){
                left = right = 0;
            }
        }
        
        
        return ans;
    }
}
