import java.io.*;
import java.util.*;

public class MinimizingCoins {
    static long max = 1000000000;

    public static void main (String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int x = Integer.parseInt(s[1]);
        String s1[] = br.readLine().split(" ");
        int a[] = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s1[i]);
        }
        long dp[] = new long[x+1];
        Arrays.fill(dp, max);
        dp[0] = 0;

        for(int i = 1; i <= x; i++) {
            for(int coin: a) {
                if(i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i-coin] + 1);
                }
            }
        }

        if(dp[x] == max) {
            System.out.println(-1);
        } else {
            System.out.println(dp[x]);
        }
    }
}