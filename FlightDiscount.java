//package com.company.CSES;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class FlightDiscount {
    public static class edge {
        int v;
        long wt;
        edge(int v, long wt) {
            this.v = v;
            this.wt = wt;
        }
    }
    public static class pair implements Comparable<pair> {
        int val;
        long wsf;
        pair(int val, long wsf) {
            this.val = val;
            this.wsf = wsf;
        }

        @Override
        public int compareTo(pair simpson) {
            return (int)(this.wsf - simpson.wsf);
        }
    }
    static ArrayList<ArrayList<edge>> a = new ArrayList<>();
    static ArrayList<ArrayList<edge>> b = new ArrayList<>();
    static boolean[] visited;
    public static void dij(long[] dis, int src, ArrayList<ArrayList<edge>> a) {
        visited = new boolean[100005];
        PriorityQueue<pair> q = new PriorityQueue<>();
        q.add(new pair(src, 0));
        while(!q.isEmpty()) {
            pair rem = q.remove();
            if(visited[rem.val]) continue;
            visited[rem.val] = true;
            dis[rem.val] = rem.wsf;
            for(edge e : a.get(rem.val)) {
                q.add(new pair(e.v, rem.wsf + e.wt));
            }
        }
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        for(int i = 0; i <= n; i++) {
            a.add(new ArrayList<>());
            b.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++) {
            String s1[] = br.readLine().split(" ");
            int u = Integer.parseInt(s1[0]);
            int v = Integer.parseInt(s1[1]);
            int wt = Integer.parseInt(s1[2]);
            a.get(u).add(new edge(v, wt));
            b.get(v).add(new edge(u, wt));
        }
        long[] dis1 = new long[100005];
        long[] dis2 = new long[100005];
        dij(dis1, 1, a);
        dij(dis2, n, b);
        long ans = Long.MAX_VALUE;
        for(int i = 1; i <= n; i++) {
            ArrayList<edge> e = a.get(i);
            for(edge e1 : e)
                ans = Math.min(ans, dis1[i] + dis2[e1.v] + e1.wt/2);
        }
        System.out.println(ans);
    }
}