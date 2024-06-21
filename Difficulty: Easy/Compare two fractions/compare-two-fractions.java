//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class GFG {
    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Solution ob = new Solution();
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str = read.readLine().trim();
            String ans = ob.compareFrac(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {

     String compareFrac(String str) {
        // Code here
        String[] a = str.split(", ");
        String[] n1 = a[0].split("/");
        String[] n2 = a[1].split("/");
        Integer num1 = Integer.parseInt(n1[0]);
         Integer den1 = Integer.parseInt(n1[1]);
         Integer num2 = Integer.parseInt(n2[0]);
         Integer den2 = Integer.parseInt(n2[1]);
         
         int ans = Double.compare((1.0 * num1)/den1, (1.0 * num2)/den2);
     if(ans > 0) return num1 + "/" + den1;
     else if(ans == 0) return "equal";
     else return num2+"/"+den2;

    }
}
