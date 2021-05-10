import java.io.*;
import java.util.*;

class CoinCombinations2 {
    
    static long mod = 1000000007;
	public static void main (String[] args) throws IOException
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String s[] = br.readLine().split(" ");
	    int n = Integer.parseInt(s[0]);
	    int x = Integer.parseInt(s[1]);
	    String s1[] = br.readLine().split(" ");
	    int coins[] = new int[n];
	    for(int i = 0; i < n; i++) {
	        coins[i] = Integer.parseInt(s1[i]);;
	    }
	    long dp[] = new long[x+1];
	    //Arrays.fill(dp, -1);
	    dp[0] = 1l;
	    for(int i = 0; i < coins.length; i++) {
	    	for(int j = coins[i]; j < dp.length; j++) {
			    long val = dp[j] + dp[j- coins[i]];
			    if(val >= mod) {
			        dp[j] = val - mod;
			    } else {
			        dp[j] = val;
			    }
		    }
	    }
	    System.out.println(dp[x] >= mod ? dp[x] - mod : dp[x]);
	}
}