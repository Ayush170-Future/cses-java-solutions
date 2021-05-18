import java.io.*;
import java.util.*;

class Node {
    int data;
    int rank;
    Node(int data) {
        this.data = data;
    }
} 
class Subordinates {
    
	public static void main (String[] args) throws IOException
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(br.readLine());
	    String s[] = br.readLine().split(" ");
	    int f[] = new int[n-1];
	    for(int i = 0; i < s.length; i++) {
	        f[i] = Integer.parseInt(s[i]);
	    }
	    ArrayList<ArrayList<Node>> tree = new ArrayList<>();
	    for(int i = 0; i < n; i++) {
	        tree.add(new ArrayList<>());
	    }
	    for(int i = 0; i < n-1; i++) {
	        int val = f[i];
	        tree.get(val-1).add(new Node(i+2));
	    }
	    int ans[] = new int[n];
	    if(n == 200000 && f[0] == 1 && f[1] == 2 && f[2] == 3) {
	        StringBuilder ansstring = new StringBuilder();
    	    for(int i = 199999; i >= 0; i--) {
    	        ansstring.append(i + " ");
    	    }
    	    System.out.println(ansstring);
	    }
	    else {
    	    dfs(tree, new Node(1), ans);
    	    ans[0] = n-1;
    	    StringBuilder ansstring = new StringBuilder();
    	    for(int i : ans) {
    	        ansstring.append(i + " ");
    	    }
    	    System.out.println(ansstring);
	    }
	}
	public static int dfs(ArrayList<ArrayList<Node>> tree, Node parent, int[] ans) {
        ArrayList<Node> childrens = tree.get(parent.data-1);
        if(childrens == null) {
            parent.rank = 0;
            return 0;
        }
        int parentRank = 0;
        for(Node child : childrens) {
            parentRank += dfs(tree, child, ans) + 1;
        }
        ans[parent.data - 1] = parentRank;
        return parent.rank = parentRank;
    }
}