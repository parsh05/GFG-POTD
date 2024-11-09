//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String arr[] = br.readLine().split(" ");
            int a[] = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                a[i] = Integer.parseInt(arr[i]);
            }
            Solution obj = new Solution();
            int f = 0;
            String A = obj.minSum(a);
            System.out.println(A);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    String minSum(int[] arr) {
        int n = arr.length;
        arr = Arrays.stream(arr)
                      .boxed()  // Convert int to Integer
                      .sorted(Collections.reverseOrder())
                      .mapToInt(Integer::intValue)  // Convert Integer back to int
                      .toArray();
        int i = 0;
        StringBuilder ans = new StringBuilder();
        int carry = 0;
        while(i < n){
            int digSum = arr[i] + carry;
            if(i+1 < n) digSum += arr[i+1];
            carry = digSum / 10;
            digSum %= 10;
            ans.append(Integer.toString(digSum));
            i = i+2;
        }
        if(carry != 0) ans.append(Integer.toString(carry));
        while (ans.length() > 0 && ans.charAt(ans.length() - 1) == '0') {
    ans.deleteCharAt(ans.length() - 1);
}

        String s = ans.reverse().toString();
        return s;
    }
}
