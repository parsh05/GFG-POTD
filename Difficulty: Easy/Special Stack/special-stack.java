//{ Driver Code Starts
import java.util.Scanner;
import java.util.Stack;
class SpeStack{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			Stack<Integer> s=new Stack<>();
			GfG g=new GfG();
			while(!g.isEmpty(s)){
			    g.pop(s);
			}
			while(!g.isFull(s,n)){
				g.push(sc.nextInt(),s);
			}
		System.out.println(g.min(s));
		}
	}
}
// } Driver Code Ends


/*Complete the function(s) below*/
class GfG{
    int min;
	public void push(int a,Stack<Integer> s)
	{
	    //add code here.
	    if(s.size() == 0){
	        s.push(a);
	        min = a;
	        return;
	    }
	    if(a < min){
	        s.push(min - a);
	        min = a;
	    } else{
	        s.push(a);
	    }
	}
	public int pop(Stack<Integer> s)
        {
            //add code here.
            if(s.size() == 0) return 0;
            if(s.peek() < 0){
                min = min - s.peek();
              return   s.pop();
            } else{
               return s.pop();
            }
	}
	public int min(Stack<Integer> s)
        {
           //add code here.
           return min;
	}
	public boolean isFull(Stack<Integer>s, int n)
        {
           //add code here.
         return n == s.size();
	}
	public boolean isEmpty(Stack<Integer>s)
        {
           //add code here.
           return s.size() == 0;
	}
}