//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String A = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.FirstNonRepeating(A);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends



class Solution {
    public String FirstNonRepeating(String s) {
        int n = s.length();
        StringBuilder ans = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        Queue<Character> q = new LinkedList<>(); // Use a queue to maintain the order of characters

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1); // Update frequency of the character
            q.add(ch); // Add the character to the queue

            // Remove characters from the front of the queue until the front is non-repeating
            while (!q.isEmpty() && map.get(q.peek()) > 1) {
                q.poll();
            }

            // Append the first non-repeating character or '#' if none exists
            if (q.isEmpty()) {
                ans.append('#');
            } else {
                ans.append(q.peek());
            }
        }

        return ans.toString();
    }
}
