import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class FlightRoutesCheck {
    static int n, m;
    static ArrayList<ArrayList<Integer>> al = new ArrayList<>();
    static boolean[] vis;
    static ArrayList<ArrayList<Integer>> transpose = new ArrayList<>();

    public static void dfs(int i) {
        vis[i] = true;
        for(int j: al.get(i)) {
            if(!vis[j]) {
                dfs(j);
            }
        }
    }

    public static void dfsT(int i) {
        vis[i] = true;
        for(int j: transpose.get(i)) {
            if(!vis[j]) {
                dfsT(j);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        vis = new boolean[n];
        for(int i = 0; i < n; i++) {
            al.add(new ArrayList<>());
            transpose.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++) {
            String[] str = br.readLine().split(" ");
            al.get(Integer.parseInt(str[0]) - 1).add(Integer.parseInt(str[1]) - 1);
            transpose.get(Integer.parseInt(str[1]) - 1).add(Integer.parseInt(str[0]) - 1);
        }

        Arrays.fill(vis, false);
        dfs(0);
        for(int i = 0; i < n; i++) {
            if(!vis[i]) {
                System.out.println("NO");
                System.out.println(1 +" " +(i+1));
                return;
            }
        }

        Arrays.fill(vis, false);
        dfsT(0);
        for(int i = 0; i < n; i++) {
            if(!vis[i]) {
                System.out.println("NO");
                System.out.println(+(i+1) +" " +(1));
                return;
            }
        }
        System.out.println("YES");
    }
}
