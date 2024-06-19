//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next, prev;

    Node(int key) {
        data = key;
        next = null;
        prev = null;
    }
}

public class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            int k = Integer.parseInt(in.readLine().trim());
            String s[] = in.readLine().trim().split(" ");
            Node head = new Node(Integer.parseInt(s[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                Node temp = new Node(Integer.parseInt(s[i]));
                tail.next = temp;
                temp.prev = tail;
                tail = temp;
            }
            Solution ob = new Solution();
            Node ans = ob.sortAKSortedDLL(head, k);
            Node temp = ans;
            while (temp != null) {
                out.print(temp.data + " ");
                temp = temp.next;
            }out.println();
        }
        out.close();

    }
}

// } Driver Code Ends


//User function Template for Java
class Solution {
    public Node sortAKSortedDLL(Node head, int k) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.data - b.data );
        
        Node h = new Node(-1);
        
        Node t = head , t1 = h;
        Node lastsorted = null;
        while( t != null ){
            pq.add( t );
            if( pq.size () > k) {
                lastsorted = pq.poll();
                lastsorted.prev = t1;
                t1.next = lastsorted;
                t1 = t1.next;
            }
            t = t.next;
        }
        while( pq.size() > 0 ){
                lastsorted = pq.poll();
                lastsorted.prev = t1;
                t1.next = lastsorted;
                t1 = t1.next;
        }
        lastsorted.next = null;
        h = h.next;
        h.prev = null;
        return h;
    }
}