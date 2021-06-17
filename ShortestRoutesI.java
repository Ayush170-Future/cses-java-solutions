//package com.company.CSES;

import java.util.*;
import java.io.*;

class ShortestRoutesI {

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
            long wt = Long.parseLong(st.nextToken());
            a.get(u).add(new edge(v, wt));
            //a.get(v).add(new edge(u, wt));
        }
        visited = new boolean[n+1];
        long ans[] = new long[n+1];
        PriorityQueue<pair> q = new PriorityQueue<>();
        q.add(new pair(1, 0));
        while(!q.isEmpty()) {
            pair rem = q.remove();
            if(visited[rem.val]) continue;
            visited[rem.val] = true;
            ans[rem.val] = rem.wsf;
            for(edge e : a.get(rem.val)) {
                q.add(new pair(e.v, rem.wsf + e.wt));
            }
        }
        for(int i = 1; i <= n; i++) {
            out.print(ans[i] +" ");
        }
        out.close();
    }
}