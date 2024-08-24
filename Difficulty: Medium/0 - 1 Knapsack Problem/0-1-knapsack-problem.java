//{ Driver Code Starts
import java.io.*;
import java.util.*;

class gfg {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int w = Integer.parseInt(br.readLine());

            String line = br.readLine();
            String[] tokens = line.split(" ");
            List<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] val = new int[array.size()];
            int idx = 0;
            for (int i : array) val[idx++] = i;

            String lin = br.readLine();
            String[] toke = lin.split(" ");
            List<Integer> array1 = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : toke) {
                array1.add(Integer.parseInt(token));
            }

            int[] wt = new int[array1.size()];
            idx = 0;
            for (int i : array1) wt[idx++] = i;

            // calling method knapSack() of class Solution
            System.out.println(new Solution().knapSack(w, wt, val));
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[]) {
        // your code here
        int n = wt.length;
        
        return solve(W, n, wt, val);
    }
    private static int solve(int W,int n, int wt[], int val[]){
        ArrayList<Integer> prev = new ArrayList<>();
        for(int i = 0; i <= W; i++) prev.add(0);
        ArrayList<Integer> curr = new ArrayList<>();
        for(int i = 0; i <= W; i++) curr.add(0);
        
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= W; j++){
                if(wt[i-1] <= j) {
                    int currtotalWt  = Math.max( val[i-1] + prev.get(j-wt[i-1] ) , prev.get(j) );
                    curr.set(j, currtotalWt);
                } else  curr.set(j, prev.get(j))  ;
            }
            
            // now 
            ArrayList<Integer> newNext = prev;
            prev = curr;
            curr = newNext;
        }

        return prev.get(W);
    }
}
