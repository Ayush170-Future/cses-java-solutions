import java.io.*;
import java.util.*;

class SubarraySums1 {
    
	public static void main (String[] args) throws IOException
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String s1[] = br.readLine().split(" ");
	    int n = Integer.parseInt(s1[0]);
	    int x = Integer.parseInt(s1[1]);
	    String s[] = br.readLine().split(" ");
	    HashSet<Long> set = new HashSet<>();
	    int ans = 0;
	    long sum = 0;
	    set.add(0l);
	    for(String str : s) {
	        int val = Integer.parseInt(str);
	        sum += val;
	        if(set.contains(sum - (long)x))
	            ans++;
	        set.add(sum);
	    }
	    //if(set.contains(sum - (long)x))
	      //  ans++;
	    System.out.println(ans);
	}
}