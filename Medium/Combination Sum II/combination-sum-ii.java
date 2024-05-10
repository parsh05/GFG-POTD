//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int a[] = new int[n];
            s = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);
            List<List<Integer>> ans = new Solution().CombinationSum2(a, n, k);
            for (List<Integer> list : ans) {
                for (int x : list) ot.print(x + " ");
                ot.println();
            }
            if (ans.size() == 0) ot.println();
        }
        ot.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public List<List<Integer>> CombinationSum2(int arr[], int n, int k) {
        // Code Here.
        Arrays.sort(arr);
        ArrayList<Integer> a = new ArrayList<>();
        for (int num : arr) {
             a.add(num); // Autoboxing converts int to Integer
        }
        return combinationSum(a,k);
    }
    List<List<Integer>> combinationSum(ArrayList<Integer> arr, int target)
    {
        // add your code here
        Collections.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<Integer>();
        fn(target,arr,0,curr,ans);
        return ans;
    }
    void fn(int target, ArrayList<Integer> arr, int index, List<Integer> curr,List<List<Integer>> ans){

        if(target==0){
            List<Integer> a = new ArrayList<>(curr);
            ans.add(a);
            return ;
        }
        if(index>=arr.size())return ;
        for(int i=index;i<arr.size();i++){
            if(arr.get(i) > target ) break;
            if(i>index && arr.get(i) == arr.get(i-1) )continue;
            curr.add(arr.get(i));
            fn(target - arr.get(i) , arr , i+1 , curr,ans);
            curr.remove(curr.size()-1);
        }
    }

}
