//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String s = in.readLine();
            int k = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            System.out.println(ob.minValue(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int minValue(String s, int k) {
        // code here
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(s.charAt(i),1 + map.getOrDefault(s.charAt(i), 0));
            
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a,b)->
            map.get(b) - map.get(a));
        for(char ch : map.keySet()) pq.add(ch);
        
        while(k-- > 0 && pq.size() > 0){
            char ch = pq.poll();
            map.put(ch, map.get(ch) - 1);
            if(map.get(ch) > 0) pq.add(ch);
        }
        int ans = 0;
        while(pq.size() > 0){
            int freq = map.get(pq.poll());
            ans += freq * freq;
        }
        return ans;
    }
}