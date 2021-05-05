import java.io.*;
import java.util.*;

class Pair{
    int val;
    int i;
    Pair(int val, int i) {
        this.val = val;
        this.i = i;
    }
}
class NearestSmallerValues {
    
	public static void main (String[] args) throws IOException
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    Stack<Pair> st = new Stack<>();
	    int n = Integer.parseInt(br.readLine());
	    String s[] = br.readLine().split(" ");
	    int a[] = new int[n];
	    for(int i = 0; i < n; i++) {
	        a[i] = Integer.parseInt(s[i]);
	    }
	    int ans[] = new int[n];
	    for(int i = 0; i < n; i++) {
	        while(!st.isEmpty() && st.peek().val >= a[i]) {
	          st.pop();  
	        }
	        if(st.isEmpty()) {
	            ans[i] = 0;
	        }
	        else if(st.peek().val < a[i]) {
	            ans[i] = st.peek().i + 1;
	        }
	        st.push(new Pair(a[i], i));
	    }
	    for(int i = 0; i < n; i++) {
	        System.out.print(ans[i] +" ");
	    }
	}
}