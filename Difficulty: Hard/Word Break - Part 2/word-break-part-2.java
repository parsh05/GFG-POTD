//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.stream.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String arr[] = in.readLine().trim().split("\\s+");
            List<String> dict = new ArrayList<String>();
            for(int i = 0;i < n;i++)
                dict.add(arr[i]);
            String s = in.readLine();
            
            Solution ob = new Solution();
            List<String> ans = new ArrayList<String>();
            ans = ob.wordBreak(n, dict, s);
            if(ans.size() == 0)
                System.out.println("Empty");
            else{
                List<String> sol = ans.stream().sorted().collect(Collectors.toList());
                for(int i = 0;i < sol.size();i++)
                    System.out.print("("+sol.get(i)+")");
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static void solve(int i, List<String> dict, String s, String currSentence, List<String> result) {
        // Base case: if we have reached the end of the string
        if (i == s.length()) {
            result.add(currSentence.trim()); // Add the sentence to result and trim trailing spaces
            return;
        }
        
        // Try building words from index i to the rest of the string
        String currWord = ""; // Initialize an empty current word
        for (int j = i; j < s.length(); j++) {
            currWord += s.charAt(j); // Build the word one character at a time

            // If the word is in the dictionary, continue with the rest of the string
            if (dict.contains(currWord)) {
                // Recursive call: move forward in the string with the updated current sentence
                solve(j + 1, dict, s, currSentence + currWord + " ", result);
            }
        }
    }

    static List<String> wordBreak(int n, List<String> dict, String s) {
        List<String> result = new ArrayList<>(); // List to store all valid sentences
        solve(0, dict, s, "", result); // Start solving from index 0
        return result; // Return the final result list
    }

}