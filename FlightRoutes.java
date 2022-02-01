import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FlightRoutes {

    static class edge {
        int v;
        long wt;
        edge(int v, long wt) {
            this.v = v;
            this.wt = wt;
        }
    }

    static class pair implements Comparable<pair>  {
        int v;
        long wsf;
        pair(int v, long wsf) {
            this.v = v;
            this.wsf = wsf;
        }

        @Override
        public int compareTo(pair simpson) {
            return (int)(this.wsf - simpson.wsf)    ;
        }
    }

    static ArrayList<ArrayList<edge>> al = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int k = Integer.parseInt(s[2]);

        for(int i = 0; i < m; i++) {
            al.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            String str[] = br.readLine().split(" ");
            int u = Integer.parseInt(str[0]);
            int v = Integer.parseInt(str[1]);
            long c = Long.parseLong(str[2]);
            al.get(u).add(new edge(v, c));
        }
        HashMap<Integer, ArrayList<Long>> map = new HashMap<>();

        for(int i = 1; i < n; i++) {
            map.put(i, new ArrayList<>());
            for(int j = 0; j < k; j++) {
                map.get(i).add(Long.MAX_VALUE);
            }
        }

        map.put(0, new ArrayList<>());
        for(int i = 0; i < k; i++) {
            map.get(0).add((long)0);
        }

        PriorityQueue<pair> q = new PriorityQueue<>();

        q.add(new pair(0, 0));

        while (!q.isEmpty()) {
            int u = q.peek().v;
            long wsf = q.peek().wsf;
            q.poll();
            if(map.get(u).get(k-1) < wsf) continue;

            for(edge e : al.get(u)) {
                int v = e.v;
                long wt = e.wt;

                if(map.get(v).get(k-1) > wt + wsf) {
                    map.get(v).add(k-1, wt + wsf);
                    q.add(new pair(v, wt + wsf));
                    Collections.sort(map.get(v));
                }
            }
        }

        for(long i : map.get(n-1)) {
            System.out.println(i);
        }
        System.out.println(Long.MAX_VALUE);

    }
}
