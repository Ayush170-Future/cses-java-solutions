import java.io.*;
import java.util.*;

class TwoSets2 {
    public static void main (String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long mod = 1000000007;
        int n = Integer.parseInt(br.readLine());
        int sum = (n*(n+1))/2;
        if((sum & 1) == 1) {
            System.out.println(0);
        }
        else {
            sum = sum/2;
            long dp[][] = new long[n+1][sum+1];
            dp[0][0] = 1;
            for(int i = 1; i <= n; i++) {
                for(int j = 0; j <= sum; j++) {
                    if(j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i-1][j];
                        if(dp[i][j] >= mod) {
                            dp[i][j] = dp[i][j] - mod;
                        }
                        if(j >= i)
                            dp[i][j] += dp[i-1][j - i];
                        if(dp[i][j] >= mod) {
                            dp[i][j] = dp[i][j] - mod;
                        }
                    }
                }
            }
            System.out.println((dp[n][sum] * 500000004)%mod);
        }
    }
}