//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.reverseWords(s));
            t--;
        }
    }
}

// } Driver Code Ends



class Solution {
    // Function to reverse words in a given string.
   String reverseWords(String str) {
        // code here
        StringBuilder s = new StringBuilder();
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '.'){
                arr.add( s.toString() );
                s = new StringBuilder();
            } else{
                s.append(str.charAt(i));
            }
        }
        arr.add(s.toString()); // for the last string

        int size = arr.size();
        s = new StringBuilder();
        for(int i = size - 1; i >= 0; i--){
            s.append(arr.get(i));
            if(i > 0) s.append(".");
        }
        return s.toString();
    }
}