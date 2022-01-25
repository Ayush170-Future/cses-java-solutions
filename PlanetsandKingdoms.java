import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class PlanetsandKingdoms {
    static int n, m;
    static ArrayList<ArrayList<Integer>> al = new ArrayList<>();
    static boolean[] vis;
    static ArrayList<ArrayList<Integer>> transpose = new ArrayList<>();
    static Stack<Integer> stack = new Stack<>();

    public static void dfs(int i) {
        vis[i] = true;
        for(int j: al.get(i)) {
            if(!vis[j]) {
                dfs(j);
            }
        }
        stack.push(i);
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
        for(int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(i);
            }
        }

        int[] ans = new int[n];
        int previous = 0;
        Arrays.fill(vis, false);

        while(!stack.isEmpty()) {
            int i = stack.pop();
            if(!vis[i]) {
                dfsT(i);
                previous++;
                ans[i] = previous;
            } else {
                ans[i] = previous;
            }
        }

        System.out.println(previous);
        for(int i : ans) {
            System.out.print(i +" ");
        }
    }
}
