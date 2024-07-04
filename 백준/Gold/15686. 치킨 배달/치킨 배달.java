import java.util.*;
import java.io.*;

class Point {
	int x, y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	int getDistance(int x, int y) {
		return Math.abs(this.x - x) + Math.abs(this.y - y);
	}
}

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static List<Point> home = new ArrayList<>();
	static List<Point> chicken = new ArrayList<>();
	static int N, M;
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		int[][] map;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					home.add(new Point(i, j));
				else if (map[i][j] == 2)
					chicken.add(new Point(i, j));
			}
		}

		chickChoice(new int[M], 0, 0, 0);

		bw.write(result + "");
		bw.close();
	}

	// M개의 치킨집고르기
	static void chickChoice(int[] path, int start, int depth, int flag) {
		if (depth == M) {
			int sum = 0;
			for (Point h : home) {
				int min = Integer.MAX_VALUE;
				for (int i = 0; i < path.length; i++) {
					min = Math.min(h.getDistance(chicken.get(path[i]).x, chicken.get(path[i]).y), min);
				}
				sum += min;
			}
			result = Math.min(sum, result);
			return;
		}

		for (int i = start; i < chicken.size(); i++) {
			if ((flag & (1 << i)) != 0)
				continue;
			path[depth] = i;
			chickChoice(path, i + 1, depth + 1, flag | 1 << i);
		}
	}
}