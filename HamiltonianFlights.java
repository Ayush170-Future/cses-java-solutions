import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class HamiltonianFlights {

    static ArrayList<ArrayList<Integer>> al = new ArrayList<>();
    static HashSet<Integer> vis = new HashSet<>();
    static long ans = 0;
    static int n;
    static long mod = 1000000007;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        for(int i = 0; i < n; i++) {
            al.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            String str[] = br.readLine().split(" ");
            int u = Integer.parseInt(str[0]) - 1;
            int v = Integer.parseInt(str[1]) - 1;
            al.get(u).add(v);
        }

        dfs(0);
        System.out.println(ans);
    }

    public static void dfs(int node) {

        if(node == n-1 && vis.size() == n-1) {
            ans = (ans + 1) % mod;
            return;
        }
        vis.add(node);
        for(int v : al.get(node)) {
            if(!vis.contains(v)) {
                dfs(v);
            }
        }
        vis.remove(node);
    }
}
