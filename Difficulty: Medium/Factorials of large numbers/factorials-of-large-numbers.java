//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    public static ArrayList<Integer> factorial(int n) {
        ArrayList<Integer> factorial = new ArrayList<>();
factorial.add(1);  // Initialize the factorial list with 1
int i = 1;

while (i <= n) {
    int dig = 0;
    int carry = 0;
    
    // Process each digit in the ArrayList
    while (dig < factorial.size()) {
        int digVal = factorial.get(dig);
        int mul = digVal * i + carry;
        digVal = mul % 10;
        carry = mul / 10;
        factorial.set(dig, digVal);
        dig++;  // Increment dig after processing
    }

    // Handle the carry
    while (carry != 0) {
        factorial.add(carry % 10);
        carry /= 10;
    }
    i++;
}

Collections.reverse(factorial);
return factorial;

    }
}

//{ Driver Code Starts.

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.factorial(N);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends