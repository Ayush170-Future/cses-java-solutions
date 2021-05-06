import java.io.*;
import java.util.*;

class SubarrayDivisibility {
    
	public static void main (String[] args) throws IOException
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(br.readLine());
        String str[] = br.readLine().split(" ");
        long ans = 0l;
        HashMap<Long, Long> map = new HashMap<>();
        long sum = 0l;
        map.put(0l, 1l);
        for(String s : str) {
            sum += Long.parseLong(s);
            long rem = sum % n;
            if(rem >= 0) {
                ans += map.getOrDefault(rem, 0l);
                map.put(rem, map.getOrDefault(rem, 0l) + 1l);
            } else {
                rem = n + rem;
                ans += map.getOrDefault(rem, 0l);
                map.put(rem, map.getOrDefault(rem, 0l) + 1l);
            }
        }
        System.out.println(ans);
	}
}