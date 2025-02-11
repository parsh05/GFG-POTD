//{ Driver Code Starts
import java.io.*;
import java.util.*;


class Node
{
    int data;
    Node left;
    Node right;
    
    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
    
    public static Node buildTree(String str)
    {
        // Corner Case
        if(str.length()==0 || str.charAt(0)=='N')
            return null;
        
        // Creating array of Strings from input 
        // String after spliting by space
        String ip[] = str.split(" ");
        
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        
        // Push the root to the queue
        Queue<Node> queue = new LinkedList<>(); 
        queue.add(root);
        
        // Starting from the second element
        int i = 1;
        while(queue.size()>0 && i < ip.length)
        {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N"))
            {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N"))
            {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    
    public static Node inputTree(BufferedReader br) throws IOException
    {
        return buildTree(br.readLine().trim());
    }
    
    public static void inorder(Node root)
    {
        if (root == null)
           return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            Node node1 = Node.inputTree(br);
            
            
            Node node2 = Node.inputTree(br);
            
            Solution obj = new Solution();
            boolean res = obj.areAnagrams(node1, node2);
            
            int _result_val = (res) ? 1 : 0;
            System.out.println(_result_val);
        }
    }
}

// } Driver Code Ends


/*

Definition for Binary Tree Node
class Node
{
    int data;
    Node left;
    Node right;
    
    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {

    // Function to check if all levels of two trees are anagrams or not.
    public boolean areAnagrams(Node root1, Node root2) {
        if (root1 == null && root2 == null) return true; // Both trees are empty
        if (root1 == null || root2 == null) return false; // One tree is empty

        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();

        q1.add(root1);
        q2.add(root2);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            int size1 = q1.size();
            int size2 = q2.size();

            if (size1 != size2) return false; // If the number of nodes in the level is different

            Map<Integer, Integer> freqMap = new HashMap<>();

            // Traverse the current level of tree 1 and update the frequency map
            for (int i = 0; i < size1; i++) {
                Node node1 = q1.poll();
                freqMap.put(node1.data, freqMap.getOrDefault(node1.data, 0) + 1);

                if (node1.left != null) q1.add(node1.left);
                if (node1.right != null) q1.add(node1.right);
            }

            // Traverse the current level of tree 2 and decrement the frequency map
            for (int i = 0; i < size2; i++) {
                Node node2 = q2.poll();
                freqMap.put(node2.data, freqMap.getOrDefault(node2.data, 0) - 1);

                // Remove the element from the map if its count reaches 0
                if (freqMap.get(node2.data) == 0) {
                    freqMap.remove(node2.data);
                }

                if (node2.left != null) q2.add(node2.left);
                if (node2.right != null) q2.add(node2.right);
            }

            // After processing the level, check if the map is empty
            if (!freqMap.isEmpty()) return false;
        }

        return true; // All levels are anagrams
    }
}