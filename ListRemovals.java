import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ListRemovals {
    static int size = (int) (5*1e5);
    static long[] a = new long[size];
    static long[] p = new long[size];
    static long[] segment = new long[4*size];
    public static void build(int ind, int low, int high) {
        if(low == high) {
            segment[ind] = p[low];
            return;
        }
        int mid = (low + high) / 2;
        build(2*ind+1, low, mid);
        build(2*ind+2, mid+1, high);
        segment[ind] = segment[2*ind+1] + segment[2*ind+2];
    }
    public static void pointUpdate(int ind, int low, int high, int node, int val) {
        if(low == high) {
            segment[ind] = val;
            return;
        }
        int mid = (low+high)/2;
        if(node <= mid && node >= low) pointUpdate(2*ind+1, low, mid, node, val);
        else pointUpdate(2*ind+2, mid+1, high, node, val);

        segment[ind] = segment[ind*2+1] + segment[ind*2+2];
    }
    public static long query(int ind, int low, int high, int l, int r) {
        if(low>= l && high <= r) return segment[ind];

        if(high < l || low > r) return 0;

        int mid = (low+high)/2;
        long left = query(2*ind+1, low, mid, l, r);
        long right = query(2*ind+2, mid+1, high, l, r);
        return left + right;
    }
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = 1;
        while (t-- > 0) {
            String[] st = br.readLine().split(" ");
            int n = Integer.parseInt(st[0]);
            String[] str = br.readLine().split(" ");
            long a[] = new long[n];

            for(int i = 0; i < n; i++) {
                a[i] = Long.parseLong(str[i]);
            }

            for(int i = 0; i < n; i++) p[i] = 1;
            build(0, 0, n-1);
            String[] s = br.readLine().split(" ");

            for(int i = 0; i < n; i++) {
                long val = Integer.parseInt(s[i]);
                int l = 0;
                int r = n-1;

                while(l != r) {
                    int mid = (l+r)/2;
                    long till_mid = query(0, 0, n-1, 0, mid);
                    if(till_mid > val) {
                        r = mid-1;
                    } else if(till_mid < val) {
                        l = mid+1;
                    } else {
                        if(p[(int) mid] == 1) {
                            l = mid;
                            break;
                        } else r = mid-1;
                    }
                }
                p[l] = 0;
                pointUpdate(0, 0, n-1, l, 0);
                sb.append(a[l] +" ");
            }
        }
        System.out.println(sb);
    }
}
