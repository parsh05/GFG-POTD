//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int d;
            d = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.countPartitions(n, d, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends





class Solution {
    static int mod = 1000000007;
    public static int countPartitions(int n, int d, int[] arr) {
        // code here
        int sum = 0;
        for(int i = 0; i < n; i++) sum += arr[i];
        if( (sum - d) % 2 != 0) return 0;
        int a = (sum + d)/2 ;
    
        Arrays.sort(arr);
        int[][] dp = new int [n+1][a+1];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
         return countSubsetEqualSum(arr,0, a,dp);
      
    }
    private static int countSubsetEqualSum(int[] arr,int index, int target,int[][] dp){
        
       if(index >= arr.length ){
           if(target == 0) return 1;
           return 0;
       } 
       if(dp[index][target] != -1 ) return dp[index][target];

        dp[index][target] = countSubsetEqualSum(arr,index+1, target, dp ); // doesnt choose this index's element
        if(target - arr[index] >= 0){
           dp[index][target] +=  countSubsetEqualSum(arr,index+1, target - arr[index], dp);
           dp[index][target] %= mod;
        }
       
        return dp[index][target];
    }
}
        
