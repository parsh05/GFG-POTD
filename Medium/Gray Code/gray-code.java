//{ Driver Code Starts
//Initial Template for Java
//Initial Template for Java

//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList; 


// } Driver Code Ends
//User function Template for Java

class Solution
{
    public ArrayList<String> graycode(int n)
    {
        //code here
        return toGray(n);
    }
    private ArrayList<String> toGray(int n){
        if(n==1){
            ArrayList<String> ans = new ArrayList<>();
            ans.add("0");
            ans.add("1");
            return ans;
        }
        ArrayList<String> s = toGray(n-1);
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i < s.size(); i++) {
            ans.add("0"+s.get(i));
        }
        for (int i = s.size()-1; i >= 0; i--) {
            ans.add("1"+s.get(i));
        }
        return ans;
    }
}

//{ Driver Code Starts.

class BitWise
{
	static int n;
	static int k;
	
	// Driver Code
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine()); //Inputting the testcases
		
		while(t>0) //While testcases exist
		{
			
			n = Integer.parseInt(br.readLine()); //Input N
			
			Solution obj = new Solution();
			
			ArrayList<String> ans=obj.graycode(n);
			for(int i=0;i<ans.size();i++)
			    System.out.print(ans.get(i)+" ");
			    
			System.out.println();
            
            t--;
		}
	}
	
	
}

// } Driver Code Ends