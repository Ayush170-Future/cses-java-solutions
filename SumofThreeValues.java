import java.io.*;
import java.util.*;
class Pair {
    int val;
    int i;
    Pair(int val, int i) {
        this.val = val;
        this.i = i;
    }
}
class comp implements Comparator<Pair> {
    public int compare(Pair a, Pair b)
    {
        return a.val - b.val;
    }
}
class SumofThreeValues{

     public static void main(String []args) throws IOException
     {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        ArrayList<Pair> a = new ArrayList<>();
        int n = Integer.parseInt(s[0]);
        int x = Integer.parseInt(s[1]);
        String s1[] = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            a.add(new Pair(Integer.parseInt(s1[i]), i));
        }
        Collections.sort(a, new comp());
        boolean check = false;
        int ans[] = new int[3];
        for(int i = 0; i < n; i++) {
            ans = new int[3];
            ans[0] = a.get(i).i + 1;
            check = twoSum(ans, a, x - a.get(i).val, i+1);
            if(check)
                break;
        }
        if(check) {
            Arrays.sort(ans);
            System.out.println(ans[0] +" " +ans[1] +" " +ans[2]);
        } else {
            System.out.println("IMPOSSIBLE");
        }
     }
     public static boolean twoSum(int[] ans, ArrayList<Pair> a, int sum, int i) {
        int j = a.size() - 1;
        while(i < j) {
            if((a.get(i).val + a.get(j).val) < sum) {
                i++;
            } else if((a.get(i).val + a.get(j).val) > sum) {
                j--;
            } else {
                ans[1] = a.get(i).i+1;
                ans[2] = a.get(j).i+1;
                return true;
            }
        }
        return false;
     }
}