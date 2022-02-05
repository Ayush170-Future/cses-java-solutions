import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArrayDescription {
    static long mod = 1000000007;

    public static void main (String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        String[] str = br.readLine().split(" ");

        int[] v = new int[n];

        for(int i = 0; i < n; i++) {
            v[i] = Integer.parseInt(str[i]);
        }

        long[][] dp = new long[n+2][m+2];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(i == 1) {
                    if(v[i-1] == 0 || v[i-1] == j) {
                        dp[i][j] = 1;
                    } else dp[i][j] = 0;
                } else {
                    if(v[i-1] == 0 || v[i-1] == j) {
                        dp[i][j] = ((dp[i-1][j] + dp[i-1][j-1])% mod + dp[i-1][j+1]) % mod;
                    } else dp[i][j] = 0;
                }
            }
        }

        long ans = 0;
        for(int j = 1; j <= m; j++) {
            ans = (ans + dp[n][j]) % mod;
        }
        System.out.println(ans);
    }
}
