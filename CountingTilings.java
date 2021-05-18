import java.io.*;
import java.util.*;
 
class CountingTilings {
    static long[][] dp = new long[1000+1][1<<11];
	static long mod = 1000000007;
	public static void main (String[] args) throws IOException
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String s[] = br.readLine().split(" ");
	    int n = Integer.parseInt(s[0]);
	    int m = Integer.parseInt(s[1]);
	    for(long arr[] : dp) {
	        Arrays.fill(arr, -1l);
	    }
	    long ans = solve(1, 0, n, m);
	    System.out.println(ans);
	}
	public static long solve(int col, int mask, int n, int m) {
	    if(col == m+1) {
	        if(mask == 0) {
	            return 1l;
	        }
	        return 0l;
	    }
	    if(dp[col][mask] != -1) {
	        return dp[col][mask];
	    }
	    long ans = 0l;
	    ArrayList<Integer> nextMasks = new ArrayList<>();
	    generateNewMask(mask, 1, 0, nextMasks, n, m);
	    for(int nextMask : nextMasks) {
	        ans = (ans + solve(col+1, nextMask, n, m)) % mod;
	    }
	    return dp[col][mask] = ans;
	}
	public static void generateNewMask(int currentMask, int i, int nextMask, ArrayList<Integer> nextMasks, int n, int m) {
	    if(i == n+1) {
	        nextMasks.add(nextMask);
	        return;
	    }
	    if((currentMask & (1 << i)) != 0) {
	        generateNewMask(currentMask, i+1, nextMask, nextMasks, n, m); //when this ith place is occupied.
	    }
	    if(i != n) {
	       if((currentMask & (1 << i)) == 0 && (currentMask & (1 << i+1)) == 0)
	            generateNewMask(currentMask, i+2, nextMask, nextMasks, n, m);
	    }
	    if((currentMask & (1 << i)) == 0) {
	        generateNewMask(currentMask, i+1, nextMask + (1 << i), nextMasks, n, m);
	    }
	}
}