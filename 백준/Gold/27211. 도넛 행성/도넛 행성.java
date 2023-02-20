import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[][] map;

	static class Pair {
		int x;
		int y;

		public Pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int result = 0;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {

			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					bfs(i, j);
					result++;
				}
			}
		}
		bw.write(result + "");
		bw.flush();
	}

	static void bfs(int x, int y) {
		Queue<Pair> queue = new LinkedList<>();

		queue.add(new Pair(x, y));

		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { -1, 1, 0, 0 };

		while (!queue.isEmpty()) {
			Pair p = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];

				if (nx == -1)
					nx = N - 1;
				if (ny == -1)
					ny = M - 1;
				if (nx == N)
					nx = 0;
				if (ny == M)
					ny = 0;

				if (map[nx][ny] == 0) {
					map[nx][ny] = 1;
					queue.add(new Pair(nx, ny));
				}
			}
		}
	}
}
