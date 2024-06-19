//{ Driver Code Starts
import java.util.Scanner;
import java.util.*;
import java.io.*;

class Node
{
	int data;
	Node next;
	Node bottom;
	
	Node(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}


class Flatttening_A_LinkedList
{	
    Node head;
	
	void printList(Node node)
    {
        //Node temp = head;
        while (node != null)
        {
            System.out.print(node.data + " ");
            node =node.bottom;
        }
        System.out.println();
    }
	public  static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		Flatttening_A_LinkedList list = new Flatttening_A_LinkedList();
		while(t>0)
		{
			int N = sc.nextInt();
			int arr[] = new int[N];
			for(int i=0;i<N;i++)
				arr[i] = sc.nextInt();
			
			Node temp = null;
			Node tempB = null;
			Node pre = null;
			Node preB = null;	
			int flag=1;
			int flag1=1;
			for(int i=0; i<N;i++)
			{
				int m = arr[i];
				m--;
				int a1 = sc.nextInt();
				temp = new Node(a1);
				if(flag == 1)
				{
					list.head = temp;
					pre = temp;
					flag = 0;
					flag1 = 1;
				}
				else
				{
					pre.next = temp;
					pre = temp;
					flag1 = 1;
				}
				
				for(int j=0;j<m;j++)
				{
					int a = sc.nextInt();
					tempB = new Node(a);
					if(flag1 == 1)
					{
						temp.bottom = tempB;
						preB = tempB;
						flag1 = 0;
					}
					else
					{
						preB.bottom = tempB;
						preB = tempB;
					}
				}
				
			}
			//list.printList();
			GfG g = new GfG();
			Node root = g.flatten(list.head);
			list.printList(root);
		
		t--;
		}
	}	
}
// } Driver Code Ends


/*  Function which returns the  root of 
    the flattened linked list. */
class GfG
{
    Node mergeTwoLists(Node list1, Node list2) {
        if(list1 == null ) return list2;
        if( list2 == null ) return list1;
        Node t1 = list1, t2 = list2;
        Node dummy = new Node(-1);
        Node t = dummy;
        while( t1 != null || t2 != null ){
            int n1 = (t1 != null ) ? t1.data : Integer.MAX_VALUE;
            int n2 = (t2 != null ) ? t2.data : Integer.MAX_VALUE;
            if( n1 <= n2 ) {
                t.bottom = t1;
                t1 = t1.bottom;
                t = t.bottom;
            } else{
                t.bottom = t2;
                t2 = t2.bottom;
                t = t.bottom;
            }
        }
        return dummy.bottom;
    }
    Node flatten(Node root){
	// Your code here
	    if(root==null || root.next == null) return root;
	    root.next = flatten(root.next);
	    root.bottom = mergeTwoLists(root.next, root.bottom );
	    root.next = null;
	    return root; 
    }
}