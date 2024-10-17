//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] s = br.readLine().trim().split(" ");
            int[][] arr = new int[n][2];
            int j = 0;
            for (int i = 0; i < n; i++) {
                arr[i][0] = Integer.parseInt(s[j]);
                j++;
                arr[i][1] = Integer.parseInt(s[j]);
                j++;
            }
            Solution obj = new Solution();
            // The mergeOverlap function now returns a List<int[]>
            List<int[]> ans = obj.mergeOverlap(arr);

            // Printing the merged arr
            for (int[] interval : ans) {
                System.out.print(interval[0] + " " + interval[1] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public List<int[]> mergeOverlap(int[][] arr) {
        // Code here // Code here
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        
        Stack<int[]> st = new Stack<>();
        st.push(arr[0]);
        
        for(int i = 1; i < arr.length; i++){
            if(arr[i][0] <= st.peek()[1] ) {
                int[] interval = st.pop();
                interval[1] = Math.max(interval[1], arr[i][1]);
                st.push(interval);
            } else{
                st.push(arr[i]);
            }
        }
        int[][] ans = new int[st.size()][2];
        int j = st.size() - 1;
        while(st.size() > 0){
            ans[j--] = st.pop();
        }
        ArrayList<int[]> ansList = new ArrayList<>();
        for(int[] a : ans){
            ansList.add(a);
        }
        return ansList;
    }
}