import java.io.*;
import java.util.*;

class DiceCombinations {
    static long mod = 1000000007;
	public static void main (String[] args) throws IOException
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(br.readLine());
	    long dp[] = new long[n+1];
	    dp[0] = 1l;
	    for(int i = 1; i <= n; i++) {
	        long sum = 0;
	        int limit = 0;
	        if(i > 6)
	            limit = i-6;
	        for(int j = i-1; j >= limit; j--) {
	            sum += dp[j]%mod;
	        }
	        dp[i] = sum%mod;
	    }
	    System.out.println(dp[n]%mod);
	}
}