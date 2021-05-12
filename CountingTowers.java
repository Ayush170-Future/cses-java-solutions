import java.io.*;
import java.util.*;

class CountingTowers {
    static long dp[] = new long[2000000+1];
	public static void main (String[] args) throws IOException
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    long mod = 1000000007;
	    int t = Integer.parseInt(br.readLine());
	    while(t-- > 0) {
	        int n = Integer.parseInt(br.readLine());
	        long dp[][] = new long[n+2][2];
	        dp[n+1][1] = 1l;
	        dp[n+1][0] = 1l;
	        for(int i = n; i >= 2; i--) {
	            long op1 = (dp[i+1][0] + dp[i+1][1]) % mod;
	            long op2 = dp[i+1][0] % mod;
	            long op3 = 2*dp[i+1][0] % mod;
	            long op4 = dp[i+1][1] % mod;
	            dp[i][1] = (op1 + op4) % mod;
	            dp[i][0] = (op1 + op2 + op3) % mod;
	        }
	        System.out.println(dp[2][1]%mod + dp[2][0]%mod);
	    }
	}
}