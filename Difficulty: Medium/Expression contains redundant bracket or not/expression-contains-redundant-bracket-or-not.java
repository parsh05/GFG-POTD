//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            String s; 
            s = br.readLine();
            
            Solution obj = new Solution();
            int res = obj.checkRedundancy(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int checkRedundancy(String s) {
        // code here
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '+' || ch == '-' || ch == '*' || ch == '/' ) st.push(i);
            else if(ch == ')' ){
                int operator = 0;
                while(st.size() > 0 && s.charAt(st.peek()) != '(' ){
                    operator++;
                    st.pop();
                }
                st.pop();
                if(operator  == 0) return 1;
            }
        }
        return 0;
    }
}
        
