//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class ReverseInSize
{
    static Node head;
    
    public static void main (String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int a1 = Integer.parseInt(s[0]);
            Node head = new Node(a1);
            Node tail = head;
            for(int i = 1; i < n; i++)
            {
                int a = Integer.parseInt(s[i]);
                // addToTheLast(new Node(a));
                tail.next = new Node(a);
                tail =tail.next;
            }
            
            int k = Integer.parseInt(in.readLine().trim());
            Solution ob = new Solution();
            Node res = ob.reverse(head, k);
            printList(res,out);
            out.println();
        }
        out.close();
    }
    
    public static void printList(Node node,PrintWriter out)
    {
        while(node != null)
        {
            out.print(node.data + " ");
            node = node.next;
        }
    }
    
}


// } Driver Code Ends

class Solution
{
    public static Node reverse(Node node, int k)
    {
        //Your code here
        int j = 0;
        Node curr = node, prev = null, next = null;
        while ( j++ < k && curr != null ){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
        }
        Node h = prev;
        if( curr == null ) return h;
        Node before = node;
        
        while( curr != null ){
            int i = 0;
            Node last = curr;
            while( i++ < k && curr != null ) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            before.next =prev;
            before = last;
            prev = last;
        }
        prev.next = null;
        return h;
    }
}

