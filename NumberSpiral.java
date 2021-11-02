import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberSpiral {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            String s[] = br.readLine().split(" ");
            long a = Long.parseLong(s[0]);
            long b = Long.parseLong(s[1]);
            long ans = -1;
            if(b > a) {
                if(b %2 == 0) {
                    ans = (b-1)*(b-1)+a;
                } else {
                    ans = b*b - a + 1;
                }
            } else {
                if(a %2 == 0) {
                    ans = a*a - b + 1;
                } else {
                    ans = (a-1)*(a-1) + b;
                }
            }
            sb.append(ans);
            sb.append(System.getProperty("line.separator"));
        }
        System.out.println(sb);
    }
}
