//{ Driver Code Starts
// Initial Template for Java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character
        while (t-- > 0) {
            String input = sc.nextLine();
            String[] inputArr = input.split(" ");
            int[] arr = new int[inputArr.length];
            for (int i = 0; i < inputArr.length; i++) {
                arr[i] = Integer.parseInt(inputArr[i]);
            }

            Solution ob = new Solution();
            long ans = ob.findSmallest(arr);
            System.out.println(ans);
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    public long findSmallest(int[] arr) {
        // Your code goes here
        int n = arr.length;
        int res = 1; // Initialize result
 
          // sort the input array
          Arrays.sort(arr);
       
        // Traverse the array and increment 'res' if arr[i] is
        // smaller than or equal to 'res'.
        for (int i = 0; i < n; i++)
        {
          if(arr[i] > res){
            return res;
           }
          else{
            res+=arr[i];
          }
        }
             
        return res;
    }
    
}