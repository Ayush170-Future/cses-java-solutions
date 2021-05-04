import java.io.*;
import java.util.*;
public class ReadingBooks{

     public static void main(String []args) throws IOException
     {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s[] = br.readLine().split(" ");
        int a[] = new int[n];
        long sum = 0;
        long max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s[i]);
            sum += a[i];
            if(a[i] > max)
                max = a[i];
        }
        System.out.println(Math.max(sum, 2 * max));
     }
}