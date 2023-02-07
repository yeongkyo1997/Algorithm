import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2630 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[][] map;
	static int[][] visited;
	static int white = 0;
	static int blue = 0;

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		recursion(0, N, 0, N);
		bw.write(white + "\n");
		bw.write(blue + "\n");
		bw.close();
	}

	static boolean check(int x1, int x2, int y1, int y2) {
		int cur = map[x1][y1];
		for (int i = x1; i < x2; i++) {
			for (int j = y1; j < y2; j++) {
				if (map[i][j] != cur)
					return false;
			}
		}
		if (cur == 0)
			white++;
		else
			blue++;

		return true;
	}

	static void recursion(int x1, int x2, int y1, int y2) {
		if (x1 == x2 && y1 == y2) {
			return;
		}

		if (check(x1, x2, y1, y2))
			return;

		recursion(0, x1 / 2, 0, y1 / 2);
		recursion(0, x1 / 2, y1 / 2, y2 / 2);
		recursion(x1 / 2, x2 / 2, 0, y1 / 2);
		recursion(x1 / 2, x2 / 2, y1 / 2, y2 / 2);
	}
}