//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends




// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[]) {
        // code here
        int n = arr.length;
        int xxory = 0;
        for(int i=0;i<n;i++){
            xxory = xxory ^ arr[i] ^ (i+1);
        }
        int rmsb = xxory & (-xxory) ;
        int setA = 0 , setB = 0;
        for(int i=0;i<n;i++){
            if((arr[i] & rmsb) == 0) setA = setA^arr[i];
            else setB = setB^arr[i];
        }
        
        for(int i=1;i<=n;i++){
            if( (i & rmsb) == 0) setA = setA^i;
            else setB = setB^i;
        }
        int[] ans = new int[2];
        for(int i=0;i<n;i++){
            if(arr[i] == setA){
                ans[0] = setA;
                ans[1] = setB;
                break;
            } 
            if(arr[i] == setB ){
                ans[0] = setB;
                ans[1] = setA;
            }
        }
        return ans;
    }
}