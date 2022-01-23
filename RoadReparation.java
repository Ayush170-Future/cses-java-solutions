import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class RoadReparation {

    public static class Edge implements Comparable<Edge>
    {
        int v;
        int val;
        Edge(int v, int val) {
            this.v = v;
            this.val = val;
        }

        public int compareTo(Edge simpson) {
            return this.val - simpson.val;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        ArrayList<ArrayList<Edge>> al = new ArrayList<>();
        PriorityQueue<Edge> q = new PriorityQueue<>();
        q.add(new Edge(0, 0));
        for(int i = 0; i < n; i++) {
            al.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++) {
            String s1[] = br.readLine().split(" ");
            int a = Integer.parseInt(s1[0]);
            int b = Integer.parseInt(s1[1]);
            int val = Integer.parseInt(s1[2]);
            al.get(a-1).add(new Edge(b-1, val));
            al.get(b-1).add(new Edge(a-1, val));
        }
        boolean flag = false;
        boolean[] vis = new boolean[n];
        long ans = 0;
        int count = 0;
        while(!q.isEmpty()) {
            Edge rem = q.remove();
            if(vis[rem.v]) continue;
            vis[rem.v] = true;
            int u = rem.v;
            ans += rem.val;
            count++;
            for(Edge e: al.get(u)) {
                if(!vis[e.v]) {
                    q.add(e);
                }
            }
        }
        if(count == n) System.out.println(ans);
        else System.out.println("IMPOSSIBLE");
    }
}
