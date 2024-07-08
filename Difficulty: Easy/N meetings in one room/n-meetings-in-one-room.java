//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) 
                end[i] = Integer.parseInt(inputLine[i]);
                
            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

class Pair implements Comparable<Pair>{
    int start;
    int end;
    Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }
    @Override
    public int compareTo(Pair o){
        if(this.start == o.start ) return o.end - this.end;
        return this.start - o.start;
    }
}

class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        // add your code here
        Pair[] meetings = new Pair[n];
        for(int i = 0; i < n; i++ ){
            meetings[i] = new Pair(start[i], end[i]);
        }
        Arrays.sort(meetings);
        int count = 0;
        int begin = Integer.MAX_VALUE;
        for(int i = n - 1; i >= 0; i--){
            if(meetings[i].end < begin ){
                count++;
                begin = meetings[i].start;
            }
        }
        return count;
    }
}
