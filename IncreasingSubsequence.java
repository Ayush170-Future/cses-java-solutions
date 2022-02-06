import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class IncreasingSubsequence {
    long mod = 1000000007;
    public static void main (String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];

        String s[] = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();

        for(int num: nums) {
            Integer floor = map.floorKey(num);
            Integer len = 1;
            if(floor != null) {
                if(floor == num) {
                    len = map.get(floor);
                } else {
                    len += map.get(floor);
                }
            }

            Integer ceil = map.ceilingKey(num);
            map.put(num, len);

            if(ceil != null && ceil > num && map.get(ceil) <= len) {
                map.remove(ceil);
            }
        }

        int ans = 0;
        for(int val: map.values()) {
            ans = Math.max(ans, val);
        }
        System.out.println(ans);
    }
}
