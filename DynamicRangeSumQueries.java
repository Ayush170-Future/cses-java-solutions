import java.util.*;
import java.io.*;

class DynamicRangeSumQueries {
	static long seg[];
	static int a[];
	static void built(int ind, int low, int high) {
        if(low == high) {
            seg[ind] = a[low];
            return;
        }
        int mid = (low + high)/2;
        built(2*ind + 1, low, mid);
        built(2*ind + 2, mid+1, high);
        seg[ind] = seg[2*ind + 1] + seg[2*ind + 2];
	}
	static void update(int ind, int low, int high, int value, int i) {
	    if(low == high) {
	        if(low == ind) {
	            seg[i] = value;
	        }
	        return;
	    }
	    if(ind >= low && high >= ind) {
	        seg[i] += value - a[ind];
	    }
	    int mid = (low + high)/2;
	    update(ind, low, mid, value, 2*i + 1);
	    update(ind, mid + 1, high, value, 2*i + 2);
	}
	static long query(int ind, int low, int high, int l, int r) {
	    if(low >= l && high <= r) {
	        return seg[ind];
	    }
	    if(high < l || low > r) return 0;
	    int mid = (low + high)/2;
	    long left = query(2*ind + 1, low, mid, l, r);
	    long right = query(2*ind + 2, mid+1, high, l, r);
	    return left + right;
	}
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
	    int n = Integer.parseInt(s[0]);
	    int q = Integer.parseInt(s[1]);
	    String s1[] = br.readLine().split(" ");
	    a = new int[n];
	    for(int i = 0; i < n; i++) {
	        a[i] = Integer.parseInt(s1[i]);
	    }
	    seg = new long[4 * n];
	    built(0, 0, n-1);
	    StringBuilder sb = new StringBuilder();
	    while(q-- > 0) {
	        String s2[] = br.readLine().split(" ");
	        if(Integer.parseInt(s2[0]) == 1) update(Integer.parseInt(s2[1])-1, 0, n-1, Integer.parseInt(s2[2]), 0);
    	    else {
    	        sb.append(query(0, 0, n-1, Integer.parseInt(s2[1]) -1, Integer.parseInt(s2[2]) -1));
    	        sb.append("\n");
    	    }
	    }
	    System.out.println(sb);
	}
}