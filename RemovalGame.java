import java.io.*;
import java.util.*;

class RemovalGame {
	public static void main (String[] args) throws IOException
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(br.readLine());
	    String s[] = br.readLine().split(" ");
	    int a[] = new int[n];
	    for(int i = 0; i < n; i++) {
	        a[i] = Integer.parseInt(s[i]);
	    }
	    long dp[][] = new long[n][n];
	    for(int g = 0; g < n; g++) {
	        for(int i = 0, j = g; j < n; i++, j++) {
	            if(g == 0) {
	                dp[i][j] = a[i];
	            } else if(g == 1) {
	                dp[i][j] = Math.max(a[i], a[j]);
	            } else {
	                long val1 = Math.min(dp[i+1][j-1], dp[i+2][j]) + a[i];
	                long val2 = Math.min(dp[i][j-2], dp[i+1][j-1]) + a[j];
	                dp[i][j] = Math.max(val1, val2);
	            }
	        }
	    }
	    System.out.println(dp[0][n-1]);
	}
}