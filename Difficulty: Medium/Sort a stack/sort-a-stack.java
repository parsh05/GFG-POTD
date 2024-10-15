//{ Driver Code Starts
import java.util.*;
import java.util.Scanner;
import java.util.Stack;

class SortedStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            Stack<Integer> s = new Stack<>();
            int n = sc.nextInt();
            while (n-- > 0) s.push(sc.nextInt());
            GfG g = new GfG();
            Stack<Integer> a = g.sort(s);
            while (!a.empty()) {
                System.out.print(a.peek() + " ");
                a.pop();
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/
class GfG {
    public Stack<Integer> sort(Stack<Integer> s) {
        // add code here.
        if(s.size() <= 1) return s;
        int a = s.pop();
        sort(s);
        insert(s, a);
        return s;
    }
    private void insert(Stack<Integer> s, int a){
        if(s.size() == 0 || s.peek() <= a){
            s.push(a);
        } else{
            int top = s.pop();
            insert(s, a);
            s.push(top);
        } 
    }
}