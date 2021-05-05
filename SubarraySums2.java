import java.io.*;
import java.util.*;

class SubarraySums2 {
    
	public static void main (String[] args) throws IOException
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String s1[] = br.readLine().split(" ");
	    int n = Integer.parseInt(s1[0]);
	    int x = Integer.parseInt(s1[1]);
	    String s[] = br.readLine().split(" ");
	    long ans = 0l;
	    HashMap<Long, Long> map = new HashMap<>();
	    map.put(0l, 1l);
	    long sum = 0l;
	    for(int i = 0; i < n; i++) {
	        int val = Integer.parseInt(s[i]);
	        sum += val;
	        if(map.containsKey(sum - x)) {
	            ans += map.get(sum - x);
	        }
	        map.put(sum, map.getOrDefault(sum, 0l) + 1);
	    }
	    System.out.println(ans);
	}
}