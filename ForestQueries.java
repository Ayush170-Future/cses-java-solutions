import java.io.*;

class ForestQueries {
	public static void main (String[] args)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int q = Integer.parseInt(s[1]);
		int a[][] = new int[n][n];
		for(int i = 0; i < n; i++) {
		    String s2 = br.readLine();
		    for(int j = 0; j < n; j++) {
		        char c = s2.charAt(j);
		        if(c == '*') {
		            a[i][j] = 1;
		        }
		    }
		}
		int dp[][] = new int[n+1][n+1];
		for(int i = 1; i <= n; i++) {
		    for(int j = 1; j <= n; j++) {
		        dp[i][j] = dp[i-1][j] + dp[i][j-1] + a[i-1][j-1] - dp[i-1][j-1];
		    }
		}
		StringBuilder sb = new StringBuilder();
		while(q-- > 0) {
		    String s3[] = br.readLine().split(" ");
		    int b = Integer.parseInt(s3[1]);
		    int a1 = Integer.parseInt(s3[0]);
		    int d = Integer.parseInt(s3[3]);
		    int c = Integer.parseInt(s3[2]);
		    int ans = dp[c][d] - dp[a1-1][d] - dp[c][b-1] + dp[a1-1][b-1];
		    sb.append(ans);
		    sb.append("\n");
		}
		System.out.println(sb);
	}
}