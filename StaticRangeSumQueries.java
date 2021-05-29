/*package whatever //do not write package name here */

import java.io.*;

class StaticRangeSumQueries{
	public static void main (String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
	    int n = Integer.parseInt(s[0]);
	    int q = Integer.parseInt(s[1]);
	    String s1[] = br.readLine().split(" ");
	    int a[] = new int[n];
	    for(int i = 0; i < n; i++) {
	        a[i] = Integer.parseInt(s1[i]);
	    }
	    long[] pre = new long[n+1];
	    for(int i = 0; i < n; i++) {
	        pre[i+1] = a[i] + pre[i];
	    }
	    StringBuilder sb = new StringBuilder();
	    while(q-- > 0) {
	        String s2[] = br.readLine().split(" ");
	        sb.append(pre[Integer.parseInt(s2[1])] - pre[Integer.parseInt(s2[0])-1] +" ");
	        sb.append("\n");
	    }
	    System.out.println(sb);
	}
}