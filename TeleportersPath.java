import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TeleportersPath {
    static ArrayList<ArrayList<Integer>> al = new ArrayList<>();
    static HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
    static HashMap<Integer, HashSet<Integer>> degree = new HashMap<>();
    static HashMap<Integer, Integer> in = new HashMap<>();
    static HashMap<Integer, Integer> out = new HashMap<>();
    static Stack<Integer> ans = new Stack<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        for(int i = 0; i < n; i++) {
            al.add(new ArrayList<>());
            map.put(i, new HashSet<>());
            out.put(i, 0);
            in.put(i, 0);
        }

        for(int i = 0; i < m; i++) {
            String str[] = br.readLine().split(" ");
            int u = Integer.parseInt(str[0]) - 1;
            int v = Integer.parseInt(str[1]) - 1;
            al.get(u).add(v);
            in.put(v, in.get(v) + 1);
            out.put(u, out.get(u) + 1);
        }

        boolean flag = false;
        for(int i = 1; i < n-2; i++) {
            if(in.get(i) != out.get(i)) {
                flag = true;
                break;
            }
        }

        if(out.get(0) - in.get(0) != 1) {
            System.out.println("IMPOSSIBLE");
        } else if (in.get(n-1) - out.get(n-1) != 1) {
            System.out.println("IMPOSSIBLE");
        } else if(flag) System.out.println("IMPOSSIBLE");
        else {
            dfs(0);

            while(!ans.isEmpty()) {
                System.out.print((ans.pop()+1) +" ");
            }
        }
    }

    public static void dfs(int node) {

        if(out.get(node) == 0) {
            ans.push(node);
            return;
        }

        for(int v : al.get(node)) {
            if(!map.get(node).contains(v)) {
                map.get(node).add(v);
                out.put(node, out.get(node) -1);
                dfs(v);
            }
        }
        ans.push(node);
    }
}
