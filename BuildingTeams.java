import java.util.*;
import java.io.*;

class BuildingTeams {

    static ArrayList<ArrayList<Integer>> a = new ArrayList<>();
    static boolean[] visited;
    static boolean flag = false;
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
        int[] house = new int[n+1];
        Arrays.fill(house, -1);
        for(int i = 1; i <= n; i++) {
            if(!visited[i]) {
                house[i] = 1;
                dfs(i, house);
            }
        }
        if(flag) {
            out.println("IMPOSSIBLE");
        }
        else {
            StringBuilder sb = new StringBuilder();
            for(int i = 1; i <= n; i++) {
                sb.append((house[i] == 0 ? 2 : 1) +" ");
            }
            out.println(sb);
        }
        out.close();
    }
    public static void dfs(int src, int[] house) {
        if(visited[src]) return;
        visited[src] = true;
        for(int edge : a.get(src)) {
            if(house[src] == house[edge]) flag = true;
            if(!visited[edge]) {
                house[edge] = 1 - house[src];
                dfs(edge, house);
            }
        }
    }
}