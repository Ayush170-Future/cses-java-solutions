import java.io.*;
class CountingNumbers {
    static long dp[][][][] = new long[20][10][2][2];
    public static long solve(String number, int n, int x, int leading_zeros, int tight) {
        if(n == 0) {
            return 1l;
        }
        if(x != -1 && dp[n][x][leading_zeros][tight] != 0) {
            return dp[n][x][leading_zeros][tight];
        }
        int lb = 0;
        int ub = tight == 1 ? number.charAt(number.length()-n) - '0' : 9;
        long ans = 0l;
        for(int dig = lb; dig <= ub; dig++) {
            if(dig == x && leading_zeros == 0)
                continue;
            ans += solve(number, n-1, dig, leading_zeros == 1 && dig == 0 ? 1 : 0, tight == 1 && dig == ub ? 1 : 0);
        }
        if(x == -1)
            return ans;
        
        return dp[n][x][leading_zeros][tight] = ans;
    }
    public static void main (String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		long a = Long.parseLong(s[0])-1;
		long b = Long.parseLong(s[1]);
		
		long ans = solve(s[1], s[1].length(), -1, 1, 1);
		dp = new long[20][10][2][2];
		ans = ans - solve(String.valueOf(a), String.valueOf(a).length(), -1, 1, 1);
		System.out.println(ans);
	}
}