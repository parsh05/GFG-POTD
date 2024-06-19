//{ Driver Code Starts
import java.util.*;

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


class GfG
{
    public static void printList(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while(t-- > 0)
        {   
            int N = sc.nextInt();
            
            Node []a = new Node[N];
            
            for(int i = 0; i < N; i++)
            {
                int n = sc.nextInt();
                
                Node head = new Node(sc.nextInt());
                Node tail = head;
                
                for(int j=0; j<n-1; j++)
                {
                    tail.next = new Node(sc.nextInt());
                    tail = tail.next;
                }
                
                a[i] = head;
            }
            
            Solution g = new Solution();
             
            Node res = g.mergeKList(a,N);
            if(res!=null)
                printList(res);
            System.out.println();
        }
    }
}
// } Driver Code Ends


/*class Node
{
    int data;
    Node next;
    
    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/

// a is an array of Nodes of the heads of linked lists
// and N is size of array a


class Solution
{
    //Function to merge K sorted linked list.
     public Node mergeTwoLists(Node list1, Node list2) {
        Node t1 = list1, t2 = list2;
        Node dummy = new Node(-1);
        Node t = dummy;
        while( t1 != null || t2 != null ){
            int n1 = (t1 != null ) ? t1.data : Integer.MAX_VALUE;
            int n2 = (t2 != null ) ? t2.data : Integer.MAX_VALUE;
            if( n1 <= n2 ) {
                t.next = t1;
                t1 = t1.next;
                t = t.next;
            } else{
                t.next = t2;
                t2 = t2.next;
                t = t.next;
            }
        }
        return dummy.next;
    }
    Node mergeKList(Node[]arr,int K)
    {
        //Add your code here.
        Node list1 = arr[0];
        for( int i = 1; i < arr.length; i++ ){
            list1 = mergeTwoLists(list1, arr[i] );
        }
        return list1;
    }
}
