//{ Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node num1 = new Node(val);
            Node tail = num1;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node num2 = new Node(val);
            tail = num2;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addTwoLists(num1, num2);
            printList(res);
        }
    }
}

// } Driver Code Ends


/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
    //Function to add two numbers represented by linked list.
    static Node addTwoLists(Node num1, Node num2){
        // code here
        // return head of sum list
        Node n1 = reverseList(num1);
        Node n2 = reverseList(num2);
        Node t = addTwoNumbers(n1 , n2);
        Node h = reverseList(t);
        while(h.next!=null && h.data==0) h = h.next;
        return h;
    }
    public static Node reverseList(Node head) {//Method 3
        Node prev=null,curr=head,agla=head;
        while(curr!=null){
            agla=curr.next;
            curr.next=prev;
            prev=curr;
            curr=agla;
        }
        return prev;
    }
    public static Node addTwoNumbers(Node l1, Node l2) {
        Node t1 = l1 , t2 = l2 ;
        Node h = new Node (-1);
        Node t = h; 
        int carry = 0;
        while(t1!=null && t2 != null){
            int n1 =  t1.data;
            int n2 =  t2.data;
            int dig = (n1 + n2+carry)%10;
            t.next = new Node(dig);
            carry = (n1+n2+carry)/10;
            t = t.next;
            t1 = t1.next;
            t2 = t2.next;
        }

        while(t1!=null){
            int dig = (t1.data+carry)%10;
            t.next = new Node(dig);
            carry = (t1.data + carry)/10;
            t = t.next;
            t1 = t1.next;
        }
        while(t2!=null){
            int dig = (t2.data+carry)%10;
            t.next = new Node(dig);
            carry = (t2.data + carry)/10;
            t = t.next;
            t2 = t2.next;
        }
        if(carry > 0){
            t.next = new Node(carry);
        }
        return h.next;
    }
    
}