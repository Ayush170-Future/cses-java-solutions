import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class KnightsTour {

    static int[][] ans = new int[8][8];
    static int count = 1;
    public static class Pair {
        int x;
        int y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        int y = Integer.parseInt(s[0])-1;
        int x = Integer.parseInt(s[1])-1;
        for(int i = 0; i < 64; i++) {
            ans[x][y] = count;
           ArrayList<Pair> curr_possibility = findPossibility(x, y);
           int min = Integer.MAX_VALUE;
           for(Pair j : curr_possibility) {
               ArrayList<Pair> val = findPossibility(j.x, j.y);
                if(val.size() < min) {
                    x = j.x;
                    y = j.y;
                    min = val.size();
                }
           }
           count++;
        }

        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                System.out.print(ans[i][j] +" ");
            }
            System.out.println();
        }
    }

    public static boolean isValid(int x, int y) {

        if(x < 0 || y < 0 || x > 7 || y > 7 || ans[x][y] != 0) {
            return false;
        }
        return true;
    }

    public static ArrayList<Pair> findPossibility(int x, int y) {
        ArrayList<Pair> possibilities = new ArrayList<>();

        int[] pos_x = {2, 1, 2, 1, -2, -1, -2, -1};
        int[] pos_y = {1, 2, -1, -2, 1, 2, -1, -2};

        for(int i = 0; i < 8; i++) {
            int x2 = pos_x[i] + x;
            int y2 = pos_y[i] + y;

            if(isValid(x2, y2)) {
                possibilities.add(new Pair(x2, y2));
            }
        }
        return possibilities;
    }
}
