import java.io.*;
import java.util.*;

public class Labyrinth{
	public static int[] dX = {-1, 0, 0, 1};
	public static int[] dY = {0, -1, 1, 0};
	public static String dirs = "ULRD";

	//Coordinates for points A and B.
	public static point A = new point(-1, -1);
	public static point B = new point(-1, -1);

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[][] blocked = new boolean[N][M];
		boolean[][] visited = new boolean[N][M];
		int[][] prevMove = new int[N][M];
		
		//Read in the grid.
		for (int i = 0; i < N; i++) {
			char[] S = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if (S[j] == '#') {
					blocked[i][j] = true;
				} else {
					blocked[i][j] = false;
					if (S[j] == 'A') {
						A = new point(i, j);
					}

					if (S[j] == 'B') {
						B = new point(i, j);
					}
				}
			}
		}
		Queue<point> q = new LinkedList<>();
		q.add(A);

		//BFS starting from point A.
		while (!q.isEmpty()) {
			point cur = q.poll();

			for (int dir = 0; dir < 4; dir++) {
				point next = new point(cur.x + dX[dir], cur.y + dY[dir]);
				//Check if the next point is visit-able.
				if (next.x < 0 || next.y < 0  || next.x >= N || next.y >= M) {
					continue;
				}
				if (blocked[next.x][next.y]) {
					continue;
				}
				if (visited[next.x][next.y]) {
					continue;
				}
				visited[next.x][next.y] = true;
				prevMove[next.x][next.y] = dir;
				q.add(next);
			}
		}

		if (visited[B.x][B.y]) {
			pw.println("YES");
			ArrayList<Integer> moves = new ArrayList<>();

			//Now we can go backwards from B to find all the moves we made.
			while ((A.x != B.x) || (A.y != B.y)) {
				int prevDir = prevMove[B.x][B.y];
				moves.add(prevDir);

				B.x = B.x - dX[prevDir];
				B.y = B.y - dY[prevDir];
			}
			Collections.reverse(moves);

			pw.println(moves.size());
			for (int i : moves) {
				pw.print(dirs.charAt(i));
			}

		} else {
			//We cannot reach point B.
			pw.println("NO");
		}
		pw.close();
	}

	public static class point {
		public int x, y;
		public point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
