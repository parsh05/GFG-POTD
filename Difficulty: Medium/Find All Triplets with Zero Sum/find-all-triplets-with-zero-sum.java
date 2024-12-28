//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

import java.util.*;

class Solution {
    public List<List<Integer>> findTriplets(int[] arr) {
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = n - 3; i >= 0; i--) {
            int target = -arr[i];
            map.putIfAbsent(arr[n - 1], new ArrayList<>());
            map.get(arr[n - 1]).add(n - 1); // Add index of the element
            
            for (int j = n - 2; j > i; j--) {
                // Check if the complement exists in the map
                if (map.containsKey(target - arr[j])) {
                    for (int index : map.get(target - arr[j])) {
                        // Add indices to the result
                        ans.add(Arrays.asList(i, j, index));
                    }
                }
                // Add the current element's index to the map
                map.computeIfAbsent(arr[j], k -> new ArrayList<>()).add(j);
            }
            map.clear(); // Clear the map for the next iteration
        }

        return ans;
    }
}





//{ Driver Code Starts.

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String line = read.readLine().trim();
            String[] numsStr = line.split(" ");
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            Solution obj = new Solution();
            List<List<Integer>> res = obj.findTriplets(nums);
            Collections.sort(res, (a, b) -> {
                for (int i = 0; i < a.size(); i++) {
                    if (!a.get(i).equals(b.get(i))) {
                        return a.get(i) - b.get(i);
                    }
                }
                return 0;
            });
            if (res.size() == 0) {
                System.out.println("[]");
            }
            for (int i = 0; i < res.size(); i++) {
                for (int j = 0; j < res.get(i).size(); j++) {
                    System.out.print(res.get(i).get(j) + " ");
                }
                System.out.println();
            }
            System.out.println("~");
        }
    }
}
// } Driver Code Ends