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


class Solution
{
    public String FirstNonRepeating(String A)
    {
        // code here
        Queue<Character> q = new LinkedList<>();
        int[] arr = new int[26];
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < A.length(); i++){
            int idx = A.charAt(i) - 'a';
            arr[idx]++;
            if( arr[idx] == 1) q.add(A.charAt(i));
            while( !q.isEmpty() && arr[q.element() - 'a'] > 1 ) q.poll();
            char toAppend = q.isEmpty() ? '#' : q.element();
            sb.append(toAppend);
        }
        return sb.toString();
    }
}