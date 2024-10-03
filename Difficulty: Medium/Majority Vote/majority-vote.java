//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String s = sc.nextLine();
            String[] parts = s.split(" ");
            List<Integer> nums = new ArrayList<>();
            for (String part : parts) {
                nums.add(Integer.parseInt(part));
            }
            Solution ob = new Solution();
            List<Integer> ans = ob.findMajority(nums);
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
// } Driver Code Ends


class Solution {
    // Function to find the majority elements in the array
    public List<Integer> findMajority(List<Integer> arr) {
        // Your code goes here.
        int n = arr.size();
        int count1 = 0, count2 = 0;
         
        // take the integers as the maximum 
        // value of integer hoping the integer
        // would not be present in the array
        int first =  Integer.MIN_VALUE;
        int second = Integer.MAX_VALUE;
     
        for (int i = 0; i < n; i++) {
     
            // if this element is previously
            // seen, increment count1.
            if (first == arr.get(i))
                count1++;
     
            // if this element is previously
            // seen, increment count2.
            else if (second == arr.get(i))
                count2++;
         
            else if (count1 == 0) {
                count1++;
                first = arr.get(i);
            }
     
            else if (count2 == 0) {
                count2++;
                second = arr.get(i);
            }
     
            // if current element is different
            // from both the previously seen
            // variables, decrement both the
            // counts.
            else {
                count1--;
                count2--;
            }
        }
     
        count1 = 0;
        count2 = 0;
     
        // Again traverse the array and 
        // find the actual counts.
        for (int i = 0; i < n; i++) {
            if (arr.get(i) == first)
                count1++;
     
            else if (arr.get(i) == second)
                count2++;
        }
        List<Integer> ans = new ArrayList<>();
        if (count1 > n / 3)
            ans.add(first);
     
        if (count2 > n / 3)
            ans.add(second);
            
        if(ans.size() == 0) ans.add(-1);
        Collections.sort(ans);
        return ans;
    }
}
