import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_3197 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int R, C;
	static char[][] map;
	static int[][] visited;
	static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.depth - o2.depth);

	static class Node {
		int x;
		int y;
		int depth;

		public Node(int x, int y, int depth) {
			super();
			this.x = x;
			this.y = y;
			this.depth = depth;
		}
	}

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new int[R][C];

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				char ch = str.charAt(j);
				if (ch == 'L')
					pq.add(new Node(i, j, 0));
				map[i][j] = ch;
			}
		}
	}

	static void bfs(int x, int y) {

	}
}