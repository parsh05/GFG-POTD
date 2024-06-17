//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

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

class Driverclass
{
    
    public static void main (String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            while(n-- > 1){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		   
		      head = new Solution().mergeSort(head);
		     printList(head);
		    System.out.println();
        }
    }
    public static void printList(Node head)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}



// } Driver Code Ends


//User function Template for Java
/*
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        this.data = key;
        next = null;
    }
} */

class Solution
{
    static Node getMid( Node head ){
        Node slow = head, fast = head;
        while ( fast.next != null && fast.next.next != null ){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
   public static Node mergeTwoLists(Node list1, Node list2) {
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
    //Function to sort the given linked list using Merge Sort.
    static Node mergeSort(Node head)
    {
        // add your code here
        if( head == null || head.next == null ) return head;
        // first break into two parts i.e., left and right
        Node mid = getMid( head );
        Node left = head;
        Node right = mid.next;
        mid.next = null;
        
        left = mergeSort( left );
        right = mergeSort( right );
        
        head = mergeTwoLists( left, right );
        return head;
    }
}


