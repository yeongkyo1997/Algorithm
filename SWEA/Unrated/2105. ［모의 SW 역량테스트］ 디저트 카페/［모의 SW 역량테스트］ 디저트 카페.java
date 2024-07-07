import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[][] map;
	static int T;
	static int N;
	static int[] dx = { 1, 1, -1, -1 }; 
	static int[] dy = { 1, -1, -1, 1 }; 
	static boolean[][] visited;
	static boolean[] cafe;
	static int result;

	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			result = -1;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < N - 2; i++) {
				for (int j = 1; j < N - 1; j++) {
					visited = new boolean[N][N];
					cafe = new boolean[101];
					visited[i][j] = true;
					cafe[map[i][j]] = true;
					tour(i, j, i, j, 1, 0);
					visited[i][j] = false;
					cafe[map[i][j]] = false;
				}
			}
			bw.write("#" + t + " " + result + "\n");
			bw.flush();
		}
		bw.close();
	}

	static void tour(int x, int y, int sx, int sy, int len, int dir) {
		for (int d = dir; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (nx == sx && ny == sy && len >= 4) {
				result = Math.max(result, len);
				return;
			}

			if (nx < 0 || ny < 0 || nx >= N || ny >= N)
				continue;
			if (visited[nx][ny] || cafe[map[nx][ny]])
				continue;

			visited[nx][ny] = true;
			cafe[map[nx][ny]] = true;
			tour(nx, ny, sx, sy, len + 1, d);
			visited[nx][ny] = false;
			cafe[map[nx][ny]] = false;
		}
	}
}