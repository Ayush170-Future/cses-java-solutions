import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Projects {
    long mod = 1000000007;

    static class project implements Comparable<project>{
        int start;
        int end;
        long money;
        project(int start, int end, long money){
            this.start = start;
            this.end = end;
            this.money = money;
        }

        @Override
        public int compareTo(project o) {
            return this.end - o.end;
        }
    }
    public static void main (String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<project> v = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            long price = Long.parseLong(s[2]);
            v.add(new project(start, end, price));
        }

        TreeSet<Integer> set = new TreeSet<>();

        Collections.sort(v);
        for(project p : v) {
            set.add(p.end);
        }

        long[] dp = new long[n+1];
        dp[0] = 0;

        for(int i = 1; i <= n; i++) {
            project p = v.get(i-1);

            long op1 = dp[i-1];
            long op2 = p.money + dp[(int)findBest(set, p.start)];

            dp[i] = Math.max(op1, op2);
        }

        System.out.println(dp[n]);
    }

    public static long findBest(TreeSet<Integer> set, int start) {

        Integer floor = set.floor(start);
        if(floor == null) return 0;
        int first = set.first();

        if(floor == first) return 0;
        else {
            return 1 + indexOf(set, floor);
        }
    }
    private static int indexOf(TreeSet<Integer> set,
                               Integer element)
    {

        int index = -1;

        // If the element exists in the TreeSet
        if (set.contains(element)) {

            // The element index will be equal to the
            // size of the headSet for the element
            index = set.headSet(element).size();
        }

        // Return the index of the element
        // Value will be -1 if the element
        // do not exist in the TreeSet
        return index;
    }
}
