//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.HashMap;


// } Driver Code Ends
// User function Template for Java

class Solution {

    static int sameOccurrence(int arr[], int x, int y) {
        // write code here
        int n = arr.length;
        int[] freqx = new int[n+1];
        int[] freqy = new int[n+1];
    //   freqx[0] = 1, freq[]
        int countx = 0, county = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] == x) countx++;
            else if(arr[i] == y) county++;
            freqx[i+1] = countx;
            freqy[i+1] = county;
        }
        
        HashMap<Integer, Integer> freqDiff = new HashMap<>();
        freqDiff.put(0, 1);
        int ans = 0;
        for(int i = 1; i <= n; i++){
            int diff = freqx[i] - freqy[i];
            ans += freqDiff.getOrDefault(diff,  0);
            freqDiff.put(diff,1 + freqDiff.getOrDefault(diff,  0));
        }
        return ans;
    }
}

//{ Driver Code Starts.
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
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

            int x = Integer.parseInt(br.readLine());
            int y = Integer.parseInt(br.readLine());
            // Create Solution object and find closest sum
            Solution ob = new Solution();
            int ans = ob.sameOccurrence(arr, x, y);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends