import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RectangleCutting {
    static long mod = 1000000007;

    public static void main (String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");

        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);

        int[][] dp = new int[a+1][b+1];

        for(int i = 1; i <= a; i++) {
            for(int j = 1; j <= b; j++) {
                if(i == j) {
                    dp[i][j] = 0;
                } else {
                    int min = Integer.MAX_VALUE;
                    for(int k = 1; k < j; k++) {
                        min = Math.min(min, 1 + dp[i][k] + dp[i][j-k]);
                    }
                    for(int k = 1; k < i; k++){
                        min = Math.min(min, 1 + dp[k][j] + dp[i-k][j]);
                    }

                    dp[i][j] = min;
                }
            }
        }

        System.out.println(dp[a][b]);
    }
}
