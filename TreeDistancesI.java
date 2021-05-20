import java.util.*;
import java.io.*;
 
class TreeDistancesI{
 
static final int maxN = 200001;

@SuppressWarnings("unchecked")
static Vector<Integer> []adj = new Vector[maxN];

static int []height = new int[maxN];
 
static int []dist = new int[maxN];

static void addEdge(int u, int v)
{
    
    adj[u].add(v);
    adj[v].add(u);
}

static void dfs1(int cur, int par)
{
    
    for(int u : adj[cur])
    {
        if (u != par)
        {
            
            dfs1(u, cur);

            height[cur] = Math.max(height[cur],
                                   height[u]);
        }
    }
 
    height[cur] += 1;
}


static void dfs2(int cur, int par)
{
    int max1 = 0;
    int max2 = 0;
 
    for(int u : adj[cur])
    {
        if (u != par)
        {
            
            if (height[u] >= max1)
            {
                max2 = max1;
                max1 = height[u];
            }
            else if (height[u] > max2)
            {
                max2 = height[u];
            }
        }
    }
    int sum = 0;
 
    for(int u : adj[cur])
    {
        if (u != par)
        {
            
            sum = ((max1 == height[u]) ?
                    max2 : max1);
 
            if (max1 == height[u])
                dist[u] = 1 + Math.max(1 + max2,
                                       dist[cur]);
            else
                dist[u] = 1 + Math.max(1 + max1,
                                       dist[cur]);
            dfs2(u, cur);
        }
    }
}

public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < adj.length; i++)
            adj[i] = new Vector<Integer>();
        for(int i = 0; i < n-1; i++) {
            String s[] = br.readLine().split(" ");
            addEdge(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
        }
        
        dfs1(1, 0);
     
        dfs2(1, 0);
     
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++)
            sb.append((Math.max(dist[i],height[i]) - 1) + " ");
        System.out.println(sb);
    }
}