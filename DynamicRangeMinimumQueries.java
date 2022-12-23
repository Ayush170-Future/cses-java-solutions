import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DynamicRangeMinimumQueries {
    static int size = (int) 5e5;
    static long[] a = new long[size];
    static long[] segment = new long[4*size];
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = 1;
        while (t-- > 0) {
            String[] st = br.readLine().split(" ");
            int n = Integer.parseInt(st[0]);
            int q = Integer.parseInt(st[1]);
            String[] str = br.readLine().split(" ");

            for(int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            build(0, 0, n-1);

            while(q-- > 0) {
                String[] s = br.readLine().split(" ");
                int o = Integer.parseInt(s[0]);
                int l = Integer.parseInt(s[1]) - 1;
                int r = Integer.parseInt(s[2]) - 1;

                if(o == 1) {
                    pointUpdate(0, 0, n-1, l, r+1);
                    a[l] = r+1;
                } else {
                    sb.append(query(0, 0, n - 1, l, r));
                    sb.append("\n");
                }
            }

            sb.append("\n");
        }
        System.out.println(sb);
    }
    static void build(int ind, int low, int high) {
        if(low == high) {
            segment[ind] = a[low];
            return;
        }
        int mid = (low + high)/2;
        build(2*ind+1, low, mid);
        build(2*ind+2, mid+1, high);
        segment[ind] = Math.min(segment[2*ind+1], segment[2*ind+2]);
    }
    static long query(int ind, int low, int high, int l, int r) {
        if(low >= l && high <= r) {
            return segment[ind];
        }
        if(high < l || low > r) return Integer.MAX_VALUE;
        int mid = (low + high) /2;
        long left = query(2*ind+1, low, mid, l, r);
        long right = query(2*ind+2, mid+1, high, l, r);
        return Math.min(left, right);
    }
    static void pointUpdate(int ind, int low, int high, int node, int val) {
        if(low == high) {
            segment[ind] = val;
        }

        else {
            int mid = (low+high)/2;
            if(node <= mid && node >= low)
                pointUpdate(2*ind+1, low, mid, node, val);
            else pointUpdate(2*ind+2, mid+1, high, node, val);

            segment[ind] = Math.min(segment[2*ind+1], segment[2*ind+2]);
        }
    }
}
