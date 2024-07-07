import java.util.*;
import java.io.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[][] map;
	static int T;
	static boolean[][] visited;
	static final int N = 16;
	static final int[] dx = { -1, 1, 0, 0 };
	static final int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		for (int t = 1; t <= 10; t++) {
			br.readLine();
			map = new int[N][N];
			int x = 0, y = 0;
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j) - '0';
					if (map[i][j] == 2) {
						x = i;
						y = j;
					}
				}
			}
			bw.write("#" + t + " " + bfs(x, y) + "\n");
		}
		bw.close();
	}

	static int bfs(int x, int y) {
		Queue<int[]> q = new ArrayDeque<>();

		q.offer(new int[] { x, y });

		while (!q.isEmpty()) {
			int[] poll = q.poll();

			for (int d = 0; d < 4; d++) {
				int nx = poll[0] + dx[d];
				int ny = poll[1] + dy[d];
				if (map[nx][ny] == 3)
					return 1;

				if (nx < 0 || ny < 0 || nx >= N || ny >= N)
					continue;
				if (map[nx][ny] != 0)
					continue;
				map[nx][ny] = 2;
				q.offer(new int[] { nx, ny });
			}
		}
		return 0;
	}
}