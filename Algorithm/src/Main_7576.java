import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7576 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[][] map;
	static int result = 0;
	static int M, N;
	static List<Node> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		M = parseInt(st.nextToken());
		N = parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = parseInt(st.nextToken());
				list.add(new Node(i, j, 0));
			}
		}

		bw.write(result + "");
		bw.flush();
		bw.close();
	}

	static class Node {
		int x, y, depth;

		public Node(int x, int y, int depth) {
			super();
			this.x = x;
			this.y = y;
			this.depth = depth;
		}
	}

	static int bfs(int x, int y) {
		Queue<Node> queue = new LinkedList<>();

		queue.add(new Node(x, y, 1));
		map[x][y] = 0;

		while (!queue.isEmpty()) {
			int[] dx = { 0, 0, -1, 1 };
			int[] dy = { -1, 1, 0, 0 };

			Node node = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = dx[i] + node.x;
				int ny = dy[i] + node.y;
				int ndepth = node.depth + 1;
				if (nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] == 0) {
					map[nx][ny] = ndepth;
				}
			}
		}
	}
}
