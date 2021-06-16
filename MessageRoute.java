import java.util.*;
import java.io.*;
 
class MessageRoute
{
    public static class Pair {
        String psf;
        int val;
        int len;
        Pair(int val, int len, String psf) {
            this.val = val;
            this.len = len;
            this.psf = psf;
        }
    }
    
    static ArrayList<ArrayList<Pair>> a = new ArrayList<>();
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
			a.get(u).add(new Pair(v, 0, ""));
			a.get(v).add(new Pair(u, 0, ""));
		}
		visited = new boolean[n+1];
		Queue<Pair> q = new LinkedList<>();
		visited[1] = true;
		q.add(new Pair(1, 1, "1 "));
		int anslen = 0;
		String ans = "";
		while(!q.isEmpty()) {
		    Pair rem = q.remove();
		    if(rem.val == n) {
		        anslen = rem.len;
		        ans = rem.psf;
		        break;
		    }
		    for(Pair edge : a.get(rem.val)) {
		        if(!visited[edge.val]) {
		            q.add(new Pair(edge.val, rem.len + 1, rem.psf +edge.val +" "));
		            visited[edge.val] = true;
		        }
		    }
		}
		if(visited[n]) {
		    out.println(anslen);
		    out.println(ans);
		} else out.println("IMPOSSIBLE");
		out.close();
	}
}