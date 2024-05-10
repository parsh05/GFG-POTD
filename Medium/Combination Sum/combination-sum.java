//{ Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public static void main (String[] args)throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        
        while(t-- >0)
        {
            String str[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            ArrayList<Integer> list = new ArrayList<>();
            str = br.readLine().trim().split(" ");
            for(int i = 0; i <n ;i++)
                list.add(Integer.parseInt(str[i]));
            str = br.readLine().trim().split(" ");    
            int sum = Integer.parseInt(str[0]);
            
            Solution ob = new Solution();
            
            res = ob.combinationSum(list, sum);
            if (res.size() == 0) {
    			out.print("Empty");
    		}
 
    		// Print all combinations stored in res.
    		for (int i = 0; i < res.size(); i++) {
    			if (res.size() > 0) {
    				out.print("(");
    				List<Integer> ij = res.get(i);
    				for (int j = 0; j < ij.size(); j++) {
    				    
    					out.print(ij.get(j));
    					if(j < ij.size()-1)
    					 out.print(" ");
    				}
    				out.print(")");
    			}
    		}
    		out.println();
    		res.clear();
	    }
	    out.flush();
    }
    
}
// } Driver Code Ends




//User function template for JAVA

class Solution
{
    //Function to return a list of indexes denoting the required 
    //combinations whose sum is equal to given number.
    
    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> arr, int target)
    {
        // add your code here
        Collections.sort(arr);
        removeDuplicates(arr);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i=0;i<arr.size();i++){
            ArrayList<Integer> curr = new ArrayList<Integer>();
            curr.add(arr.get(i));
            fn(target - arr.get(i) , arr , i , curr,ans);
        }
        return ans;
    }
    static void fn(int target , ArrayList<Integer> arr,int index , ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> ans){
        if(target==0){
            ArrayList<Integer> prev  = null;
            if(ans.size() > 0) prev = ans.get(ans.size()-1);
            if(ans.isEmpty() || !curr.equals(prev) ) ans.add(new ArrayList<>(curr));
            return ;
        }
        
        for(int i=index;i<arr.size();i++){
            if(arr.get(i) > target ) break;
            curr.add(arr.get(i));
            fn(target - arr.get(i) , arr , i , curr,ans);
            curr.remove(curr.size()-1);
        }
    }
       public static void removeDuplicates(ArrayList<Integer> sortedList) {
        if (sortedList == null || sortedList.isEmpty()) {
            return;
        }

        int currentIndex = 0;
        for (int i = 1; i < sortedList.size(); i++) {
            if (!sortedList.get(currentIndex).equals(sortedList.get(i))) {
                currentIndex++;
                sortedList.set(currentIndex, sortedList.get(i));
            }
        }

        // Remove any remaining elements after currentIndex
        sortedList.subList(currentIndex + 1, sortedList.size()).clear();
    }

}