import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MailDelivery {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        for(int i = 0; i < n; i++) {
            al.add(new ArrayList<>());
            map.put(i, 0);
        }
        for(int i = 0; i < m; i++) {
            String[] str = br.readLine().split(" ");
            int u = Integer.parseInt(str[0]) -1;
            int v = Integer.parseInt(str[1]) -1;
            al.get(u).add(v);
            al.get(v).add(u);
            map.put(u, map.get(u) + 1);
            map.put(v, map.get(v) + 1);
        }

        int flag = 0;
        for(int i = 0; i < n; i++) {
            if(map.get(i) % 2 != 0) {
                flag = 1;
                break;
            }
        }

        if(flag == 1) {
            System.out.println("IMPOSSIBLE");
        } else {
            Stack<Integer> stack = new Stack<>();
            stack.push(0);

            ArrayList<Integer> ans = new ArrayList();

            while (!stack.isEmpty()) {
                int node = stack.peek();
                if(map.get(node) == 0) {
                    ans.add(node);
                    stack.pop();
                } else {
                    int new_node = al.get(node).remove(map.get(node) - 1);
                    map.put(node, map.get(node) - 1);
                    map.put(new_node, map.get(new_node) - 1);
                    al.get(new_node).remove(new Integer(node));
                    stack.push(new_node);
                }
            }

            if(ans.size() == m+1) {
                for(int i : ans) {
                    System.out.print((i+1) +" ");
                }
            }
            else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }
}
