import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TwoKnights {

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 1;
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            String s[] = br.readLine().split(" ");
            long n = Long.parseLong(s[0]);
            for(int i = 1; i <= n; i++) {
                long k = i*i;
                long ans = k*(k-1)/2 - 4*(i-1)*(i-2);
                sb.append(ans);
                sb.append(System.getProperty("line.separator"));
            }
        }
        System.out.println(sb);
    }
}
