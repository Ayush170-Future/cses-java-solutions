import java.io.*;
import java.util.*;

class BookShop {
	public static void main (String[] args) throws IOException
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String s[] = br.readLine().split(" ");
	    int n = Integer.parseInt(s[0]);
	    int t = Integer.parseInt(s[1]);
	    String s1[] = br.readLine().split(" ");
	    int wt[] = new int[n];
	    for(int i = 0; i < n; i++) {
	        wt[i] = Integer.parseInt(s1[i]);
	    }
	    String s2[] = br.readLine().split(" ");
	    int val[] = new int[n];
	    for(int i = 0; i < n; i++) {
	        val[i] = Integer.parseInt(s2[i]);
	    }
	    int dp[][] = new int[n+1][t+1];
	    for(int i = 1; i <= n; i++) {
	        for(int j = 1; j <= t; j++) {
	            dp[i][j] = dp[i-1][j];
	            if(j >= wt[i-1]) {
	                dp[i][j] = Math.max(dp[i][j], dp[i-1][j-wt[i-1]] + val[i-1]);
	            }
	        }
	    }
        System.out.print(dp[n][t]);
	}
}