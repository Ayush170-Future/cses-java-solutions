import java.io.*;
import java.util.*;
class CompanyQueriesI {
    static int up[][] = new int[200001][20];
    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    public static void main(String[] args) throws IOException
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String s1[] = br.readLine().split(" ");
	    int n = Integer.parseInt(s1[0]);
	    int q = Integer.parseInt(s1[1]);
	    String s[] = br.readLine().split(" ");
	    for(int i = 0; i < n; i++) {
	        tree.add(new ArrayList<>());
	    }
	    for(int i = 0; i < s.length; i++) {
	        tree.get(Integer.parseInt(s[i])-1).add(i+2);
	    }
	    for(int[] arr : up) {
	        Arrays.fill(arr, -1);
	    }
	    binaryLifting(1, -1);
	    StringBuilder sb = new StringBuilder();
	    while(q-- > 0) {
	        String s3[] = br.readLine().split(" ");
	        int node = Integer.parseInt(s3[0]);
	        int k = Integer.parseInt(s3[1]);
	        sb.append(ans_query(node, k));
	        sb.append("\n");
	    }
	    System.out.println(sb);
	}
	static void binaryLifting(int src, int parent) {
	    up[src][0] = parent;
	    for(int i = 1; i < 20; i++) {
	        if(up[src][i-1] != -1) {
	            up[src][i] = up[up[src][i-1]][i-1];
	        } else up[src][i] = -1;
	    }
	    ArrayList<Integer> childrens = tree.get(src - 1);
	    if(childrens == null) return;
	    for(int child : tree.get(src - 1)) {
	        binaryLifting(child, src);
	    }
	}
	static int ans_query(int node, int jump_required)
    {
        if(node == -1 || jump_required == 0)
            return node;
        
        for(int i = 19; i >= 0; i--){
            if(jump_required >= (1<<i)){
                return ans_query(up[node][i], jump_required - (1<<i));
            }
        }
        return -1;
    }
}