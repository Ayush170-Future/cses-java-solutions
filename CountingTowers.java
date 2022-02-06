import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountingTowers {
    static long mod = 1000000007;

    public static void main (String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        int t = Integer.parseInt(s[0]);
        while (t-- > 0) {
            s[0] = br.readLine();
            int n = Integer.parseInt(s[0]);

            long[][] dp = new long[n+2][2];

            dp[n+1][0] = 1;
            dp[n+1][1] = 1;

            for(int i = n; i >= 2; i--) {
                long op1 = (dp[i+1][0] + dp[i+1][1]) % mod;
                long op2 = (dp[i+1][0]);
                long op3 = 2*dp[i+1][0] % mod;
                long op4 = dp[i+1][1];

                dp[i][0] = ((op1 + op2) % mod + op3) % mod;
                dp[i][1] = (op1 + op4) % mod;
            }

            System.out.println((dp[2][0] + dp[2][1]) % mod);
        }
    }
}
