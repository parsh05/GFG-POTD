//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String s;
            s = br.readLine();

            Solution obj = new Solution();
            String res = obj.oddEven(s);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static String oddEven(String s) {
        // code here
        HashMap<Character, Integer> freq = new HashMap<>();
        for(char ch : s.toCharArray() ) freq.put(ch, freq.getOrDefault(ch, 0) + 1 ) ;
    
        long ans = 0;
        for( char ch : freq.keySet() ){
            if( ( int )ch % 2 == 0 && (freq.get(ch)) % 2 == 0 ){
                ans++;
            } else if( (int) ch %2 == 1 && (freq.get(ch)) %2 == 1) ans++;
        }
        return (ans%2 == 0)? "EVEN" : "ODD";
    }
}
