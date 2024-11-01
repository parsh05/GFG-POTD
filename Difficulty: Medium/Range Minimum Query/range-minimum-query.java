//{ Driver Code Starts
import java.util.*;
import java.lang.*;

class Minimum
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
              arr[i] = sc.nextInt();
              
              GfG gfg = new GfG();
            int Q = sc.nextInt();
            
            
            int st[] = gfg.constructST(arr, n);
            int l,r;
            for(int i = 0; i < Q; i++)
            {
                int a = sc.nextInt();
                int b = sc.nextInt();
                l = Math.min(a,b);
                r = Math.max(a,b);
                
                System.out.print(gfg.RMQ(st, n, l, r) + " ");
                
            }
            System.out.println();
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


/* The functions which 
builds the segment tree */
class GfG
{
    static int st[];
    
    private static void buildst(int[] arr, int i, int low, int high) {
        if (low == high) {
            st[i] = arr[low];
            return;
        }
        int mid = (low + high) / 2;
        buildst(arr, 2 * i + 1, low, mid);
        buildst(arr, 2 * i + 2, mid + 1, high);
        st[i] = Math.min(st[2 * i + 1], st[2 * i + 2]);
        return;
    }

    public static int[] constructST(int[] arr, int n) {
        st = new int[4 * n]; // Use 4 * n to avoid index overflow issues
        buildst(arr, 0, 0, n - 1);
        return st;
    }

    public static int RMQ(int[] st, int n, int l, int r) {
        return rmq(l, r, 0, n - 1, 0);
    }

    static int rmq(int l, int r, int low, int high, int i) {
        if (l > high || r < low) return Integer.MAX_VALUE;
        if (low >= l && high <= r) return st[i];
        int mid = (low + high) / 2;
        int left = rmq(l, r, low, mid, 2 * i + 1);
        int right = rmq(l, r, mid + 1, high, 2 * i + 2);
        return Math.min(left, right);
    }
    
}