import java.io.*;
import java.util.*;

class RemovingDigits {
	public static void main (String[] args) throws IOException
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(br.readLine());
	    int[] dp = new int[n+1];
	    Arrays.fill(dp, Integer.MAX_VALUE);
	    dp[0] = 0;
	    for(int i = 1; i <= n; i++) {
	        for(char c : (i + "").toCharArray()) {
	            int val = c - '0';
	            dp[i] = Math.min(dp[i], dp[i - val] + 1);
	        }
	    }
	    System.out.println(dp[n]);
	}
}