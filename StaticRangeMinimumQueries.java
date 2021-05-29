import java.io.*;

class StaticRangeMinimumQueries {
    static int a[] = new int[200000];
    static int block[] = new int[448];
    static int blksize;
	public static void main (String[] args)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int q = Integer.parseInt(s[1]);
		String s2[] = br.readLine().split(" ");
		for(int i = 0; i < n; i++) {
		    a[i] = Integer.parseInt(s2[i]);
		}
		preprocess(n);
		StringBuilder sb = new StringBuilder();
		while(q-- > 0) {
		    String s3[] = br.readLine().split(" ");
		    sb.append(query(Integer.parseInt(s3[0])-1, Integer.parseInt(s3[1])-1));
		    sb.append("\n");
		}
		System.out.println(sb);
	}
	static void preprocess(int n) {
	    blksize = (int)Math.sqrt(n);
	    int bind = -1;
	    block[0] = Integer.MAX_VALUE;
	    for(int i = 0; i < n; i++) {
	        if(i % blksize == 0) {
	            bind++;
	            block[bind] = Integer.MAX_VALUE;
	        }
	        if(a[i] < block[bind]) {
	            block[bind] = a[i];
	        }
	    }
	}
	static int query(int l, int r)
    {
        int min = Integer.MAX_VALUE;
        while (l < r && l % blksize != 0 && l != 0)
        {
            if(a[l] < min) {
                min = a[l];
            }
            l++;
        }
        while (l+blksize <= r)
        {
            if(block[l / blksize] < min) {
                min = block[l/blksize];
            }
            l += blksize;
        }
        while (l <= r)
        {
            if(a[l] < min) {
                min = a[l];
            }
            l++;
        }
        return min;
    }
}