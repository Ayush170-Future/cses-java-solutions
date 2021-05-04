import java.io.*;
import java.util.*;
public class FactoryMachines{

     public static void main(String []args) throws IOException
     {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int t = Integer.parseInt(s[1]);
        int a[] = new int[n];
        String s1[] = br.readLine().split(" ");
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s1[i]);
            if(max < a[i])
                max = a[i];
        }
        long l = 1l;
        long u = (long)Math.pow(10, 18);
        long ans = 0l;
        while(l <= u) {
            long mid = (l + u)/2;
            long mpm = 0;
            for(int i = 0; i < n; i++) {
                mpm += mid / a[i];
        		if(mpm >= t) {
        		   break;
        		}
            }
            if(mpm < t) {
                l = mid + 1;
            } else {
                ans = mid;
	            u = mid - 1;
            }
        }
        System.out.println(ans);
     }
}