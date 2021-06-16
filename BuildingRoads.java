import java.util.*;
import java.io.*;
 
class BuildingRoads {
    
    static ArrayList<ArrayList<Integer>> a = new ArrayList<>();
    static boolean[] visited;
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		PrintWriter out = new PrintWriter(System.out);
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		for(int i = 0; i <= n; i++) {
		    a.add(new ArrayList<>());
		}
		for(int i = 0; i < m; i++) {
		    st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			a.get(u).add(v);
			a.get(v).add(u);
		}
		visited = new boolean[n+1];
		ArrayList<Integer> ans = new ArrayList<>();
		for(int i = 1; i <= n; i++) {
		    if(!visited[i]) {
		        ans.add(i);
		        random(i);
		    }
		}
		out.println(ans.size() - 1);
		if(ans.size() > 1) {
		    for(int i = 1; i < ans.size(); i++) {
		        out.println(ans.get(0) +" " +ans.get(i));
		    }
		}
		out.close();
	}
	public static void random(int src) {
	    if(visited[src]) return;
	    visited[src] = true;
	    for(int edge : a.get(src)) {
	        if(!visited[edge]) {
	            random(edge);
	        }
	    }
	}
}