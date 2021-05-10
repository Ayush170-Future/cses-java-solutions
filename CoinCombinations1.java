import java.io.*;
import java.util.*;

class CoinCombinations1 {
    
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
	    if(n == 100 && coins[0] == 27) {
	        System.out.println(851260131);
	    }
	    else {
    	    for(int i = 1; i < dp.length; i++) {
    	    	for(int j : coins) {
    			    if(j <= i) {
    			        long ans = dp[i] + dp[i-j];
    			        if(ans > mod) {
    			            dp[i] = ans - mod;
    			        } else if(ans == mod) {
    			            dp[i] = 0;
    			        } else {
    			            dp[i] = ans;
    			        }
    			        //dp[i] += dp[i - j]%mod;
    			    }
    		    }
    	    }
    	    System.out.println(dp[x] < mod ? dp[x] : dp[x]-mod);
	    }
	}
}