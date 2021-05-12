import java.io.*;
import java.util.*;

class EditDistance{
	public static void main (String[] args) throws IOException
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String s = br.readLine();
	    String t = br.readLine();
	    int[][] dp = new int[t.length() + 1][s.length() + 1];
	    for(int j = 0; j <= s.length(); j++) {
	        dp[0][j] = j;
	    }
	    for(int i = 0; i <= t.length(); i++) {
	        dp[i][0] = i;
	    }
	    for(int i = 1; i <= t.length(); i++) {
	        for(int j = 1; j <= s.length(); j++) {
	            char c1 = s.charAt(j-1);
	            char c2 = t.charAt(i-1);
	            if(c1 == c2) {
	                dp[i][j] = dp[i-1][j-1];
	            } else {
	                dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
	            }
	        }
	    }
	    System.out.println(dp[t.length()][s.length()]);
	} 
}