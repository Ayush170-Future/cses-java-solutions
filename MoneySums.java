import java.io.*;
import java.util.*;

class MoneySums {
	public static void main (String[] args) throws IOException
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(br.readLine());
	    String s[] = br.readLine().split(" ");
	    int a[] = new int[n];
	    int sum = 0;
	    for(int i = 0; i < n; i++) {
	        a[i] = Integer.parseInt(s[i]);
	        sum += a[i];
	    }
	    boolean dp[][] = new boolean[sum+1][n+1];
	    Arrays.sort(a);
	    dp[0][0] = true;
	    ArrayList<Integer> ans = new ArrayList<>();
	    for(int i = 1; i < dp.length; i++) {
	        for(int j = 1; j <= n; j++) {
	            int val = a[j-1];
	            if(dp[i][j-1])
	                dp[i][j] = true;
	            else if(i == val) {
	                dp[i][j] = true;
	            } else if(i > val) {
	                dp[i][j] = dp[i - val][j-1];
	            }
	        }
	        if(dp[i][n])
	            ans.add(i);
	    }
	    System.out.println(ans.size());
	    for(int val : ans) {
	        System.out.print(val +" ");
	    }
	} 
}