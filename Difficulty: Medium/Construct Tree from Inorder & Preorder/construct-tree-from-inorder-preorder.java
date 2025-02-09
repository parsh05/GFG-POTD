//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            Node root = null;

            // Read inorder array
            String[] inorderStr = (br.readLine()).trim().split(" ");
            int inorder[] = new int[inorderStr.length];
            for (int i = 0; i < inorderStr.length; i++) {
                inorder[i] = Integer.parseInt(inorderStr[i]);
            }

            // Read preorder array
            String[] preorderStr = (br.readLine()).trim().split(" ");
            int preorder[] = new int[preorderStr.length];
            for (int i = 0; i < preorderStr.length; i++) {
                preorder[i] = Integer.parseInt(preorderStr[i]);
            }

            Solution ob = new Solution();
            root = ob.buildTree(inorder, preorder);
            postOrder(root);
            System.out.println();
        }
    }

    // Function to print postorder traversal of the tree
    public static void postOrder(Node root) {
        if (root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }
}

// } Driver Code Ends


/*
class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}
*/
class Solution {
    
    public static Node buildTree(int inorder[], int preorder[]) {
        // code here
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        
        Node root = build(preorder,0,preorder.length-1 ,inorder,0,inorder.length-1,map);
        return root;
    }
    
    private static Node build(int preorder[],int preStart, int preEnd ,int inorder[],int inStart,int inEnd, Map<Integer,Integer> map){


        if(preStart>preEnd || inStart>inEnd){
            return null;
        }
        
        Node root = new Node(preorder[preStart]);
        
        int inRoot = map.get(root.data);
        
        int numsLeft = inRoot - inStart;
        
        root.left = build(preorder,preStart+1,preStart+numsLeft,inorder, inStart,inRoot-1,map);
        
        root.right = build(preorder,preStart+numsLeft+1,preEnd,inorder,inRoot+1,inEnd,map);
        return root;
        
    }
}