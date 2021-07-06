//package com.company.CSES;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class GameRoutes {
    static long ans = 0l;
    static long mod = 1000000007l;
    static long dp[];
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        boolean[] vis = new boolean[n+1];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++) {
            String s1[] = br.readLine().split(" ");
            graph.get(Integer.parseInt(s1[0])).add(Integer.parseInt(s1[1]));
        }
        dp = new long[n+1];
        Arrays.fill(dp, -1);
        dfs(n, graph, vis, 1, dp);
        System.out.println(dp[1]);
    }
    public static long dfs(int n, ArrayList<ArrayList<Integer>> graph, boolean[] vis, int parent, long[] dp) {
        if(vis[parent]) return 0;
        if(parent == n) {
            ans = (ans + 1) % mod;
            return 1;
        }
        if(dp[parent] != -1) {
            return dp[parent];
        }
        vis[parent] = true;
        long temp = 0;
        for(int v : graph.get(parent)) {
            if(!vis[v]) {
                temp = (temp + dfs(n, graph, vis, v, dp)) % mod;
            }
        }
        vis[parent] = false;
        return dp[parent] = temp;
    }
}


















