//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // Read first array
            String input = br.readLine();
            String[] inputArray = input.split(" ");
            int[] arr = Arrays.stream(inputArray).mapToInt(Integer::parseInt).toArray();

            Solution ob = new Solution();
            int res = ob.findLongestConseqSubseq(arr);

            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {

    // Function to return length of longest subsequence of consecutive integers.
    public int findLongestConseqSubseq(int[] arr) {
        // code here
        HashSet<Integer> hs = new HashSet<>();
        for(int num : arr) hs.add(num);
        int res = 0;
        for(int num : arr){
            if(hs.contains(num)){
                res = Math.max(res, solve(num, hs));
            }
        }
        return res;
    }
    
    private int solve(int num, HashSet<Integer> hs){
        if(hs.size() == 0 || !hs.contains(num)) return 0;
        hs.remove(num);
        return 1 + solve(num - 1, hs) + solve(num + 1, hs);
    }
}