//package com.company.CSES;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Investigation {
    public static class Edge implements Comparable<Edge> {
        long cost;
        int v;
        Edge(long cost, int v) {
            this.cost = cost;
            this.v = v;
        }

        @Override
        public int compareTo(Edge o) {
            return (int)(this.cost - o.cost);
        }
    }
    public static class Node {
        int v;
        int dis;
        Node(int v, int dis) {
            this.v = v;
            this.dis = dis;
        }
    }
    static ArrayList<ArrayList<Node>> a = new ArrayList<>();
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        for(int i = 0; i <= n; i++) {
            a.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++) {
            String[] s1 = br.readLine().split(" ");
            a.get(Integer.parseInt(s1[0])).add(new Node(Integer.parseInt(s1[1]), Integer.parseInt(s1[2])));
        }
        long mod = 1000000007;
        int min[] = new int[n+1];
        int max[] = new int[n+1];
        long cost[] = new long[n+1];
        int route[] = new int[n+1];
        Arrays.fill(cost, Long.MAX_VALUE);

        PriorityQueue<Edge> q = new PriorityQueue<>();
        q.add(new Edge(0, 1));
        cost[1] = 0;
        route[1] = 1;

        while(!q.isEmpty()) {
            Edge rem = q.remove();
            int u = rem.v;
            long c = rem.cost;
            if(c > cost[u]) continue;
            for(Node e : a.get(u)) {
                int v = e.v;
                int d = e.dis;
                if(c + d == cost[v]) {
                    route[v] += route[u];
                    route[v] %= mod;
                    min[v] = Math.min(min[v], min[u] + 1);
                    max[v] = Math.max(max[v], max[u] + 1);
                }
                if(c + d < cost[v]) {
                    cost[v] = c + d;
                    route[v] = route[u];
                    min[v] = min[u] + 1;
                    max[v] = max[u] + 1;
                    q.add(new Edge(cost[v], v));
                }
            }
        }
        System.out.println(cost[n] +" " +route[n] +" " +min[n] +" " +max[n]);
    }
}