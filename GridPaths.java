import java.io.*;
import java.util.*;

class GridPaths {
	
	public static void main (String[] args) throws IOException
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(br.readLine());
	    long mod = 1000000007;
	    boolean ground[][] = new boolean[n][n];
	    for(boolean temp[] : ground) 
	        Arrays.fill(temp, true);
	    for(int i = 0; i < n; i++) {
	        String s = br.readLine();
	        for(int j = 0; j < n; j++) {
	            if(s.charAt(j) == '*') {
	                ground[i][j] = false;
	            }
	        }
	    }
	    long dp[][] = new long[n][n];
	    dp[n-1][n-1] = 1l;
	    for(int j = n-1; j >= 0; j--) {
	        if(!ground[n-1][j])
	            break;
	        dp[n-1][j] = 1l;
	    }
	    for(int i = n-1; i >= 0; i--) {
	        if(!ground[i][n-1])
	            break;
	        dp[i][n-1] = 1l;
	    }
	    for(int i = n-2; i >= 0; i--) {
	        for(int j = n-2; j >= 0; j--) {
	            if(ground[i][j]) {
	                long val = dp[i+1][j] + dp[i][j+1];
	                if(val >= mod) {
	                    dp[i][j] = val - mod;
	                } else {
	                    dp[i][j] = val;
	                }
	            }
	        }
	    }
	    if(n == 1 && !ground[0][0]) {
	        System.out.println(0);
	    } else
	        System.out.println(dp[0][0] >= mod ? dp[0][0] - mod : dp[0][0]);
	}
}