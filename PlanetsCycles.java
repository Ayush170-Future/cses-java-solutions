import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.util.*;

public class PlanetsCycles {

    static long[] pathLength;
    static int steps = 0;
    static boolean[] vis;
    static Deque<Integer> q = new ArrayDeque<>();
    static int[] links;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        links = new int[n];
        for(int i = 0; i < n; i++) {
            links[i] = Integer.parseInt(s[i]) - 1;
        }
        pathLength = new long[n];
        vis = new boolean[n];

        for(int i = 0; i < n; i++) {
            if(!vis[i]) {
                q = new ArrayDeque<>();
                steps = 0;
                int sub = 1;
                dfs(i);
                while(!q.isEmpty()){

                    if(q.getFirst() == q.getLast()) {
                        sub = 0;
                    }
                    pathLength[q.getFirst()] = steps;
                    steps -= sub;
                    q.removeFirst();
                }
            }
        }
        for(long i: pathLength) {
            System.out.print(i +" ");
        }
    }

    public static void dfs(int root) {
        q.addLast(root);
        if(vis[root]) {
            steps += pathLength[root];
            return;
        }

        vis[root] = true;
        steps++;
        dfs(links[root]);
    }
}