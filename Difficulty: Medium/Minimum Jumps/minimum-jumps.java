//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            System.out.println(new Solution().minJumps(arr));
            // System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    static int minJumps(int[] arr) {
        int n = arr.length;
        if (n <= 1) return 0; // No jumps needed if the array has only one element.
        if (arr[0] == 0) return -1; // Not possible to move if the first element is 0.

        int maxReach = arr[0]; // Max index we can reach so far.
        int steps = arr[0];    // Steps we can still take.
        int jumps = 1;         // Number of jumps needed.

        for (int i = 1; i < n; i++) {
            // Check if we've reached the end of the array.
            if (i == n - 1) return jumps;

            // Update the maximum reach.
            maxReach = Math.max(maxReach, i + arr[i]);

            // Decrease the steps.
            steps--;

            // If no more steps are left.
            if (steps == 0) {
                // We must have used a jump.
                jumps++;

                // Check if the current index is beyond the max reach.
                if (i >= maxReach) return -1;

                // Reinitialize the steps to the amount of steps needed
                // to reach maxReach from position i.
                steps = maxReach - i;
            }
        }

        return -1; // If we exit the loop, it means we can't reach the end.
    }
}