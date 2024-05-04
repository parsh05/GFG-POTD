//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int value) {
        data = value;
        left = null;
        right = null;
    }
}

class InorderPostorderToTree {
    public void preOrder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);

        preOrder(root.right);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        InorderPostorderToTree ip = new InorderPostorderToTree();
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int inorder[] = new int[n];
            int postorder[] = new int[n];
            for (int i = 0; i < n; i++) inorder[i] = sc.nextInt();
            for (int i = 0; i < n; i++) postorder[i] = sc.nextInt();
            GfG g = new GfG();
            Node root = g.buildTree(inorder, postorder, n);
            ip.preOrder(root);
            System.out.println();

            T--;
        }
    }
}

// } Driver Code Ends


/* Tree node structure
class Node
{
    int data;
    Node left;
    Node right;

        Node(int value)
    {
        data = value;
        left = null;
        right = null;
    }
}*/


class GfG
{
    //Function to return a tree created from postorder and inoreder traversals.
    int post_idx = 0;
    HashMap<Integer,Integer> mp = new HashMap<>();
    Node buildTree(int in[], int post[], int n) {
        // Your code here
        post_idx = n-1;
        for(int i=0;i<n;i++){
            mp.put(in[i],i);
        }
        return build(in,post,0,n-1);
    }
    Node build(int in[],int []post,int start , int end){
        if(start>end) return null;
        Node root = new Node(post[post_idx] );
        post_idx--;
        // search root in the inorder 
        int in_idx = mp.get(root.data);
        root.right = build(in,post,in_idx+1,end);
        root.left = build(in,post,start,in_idx-1);
        return root;
    }
}
