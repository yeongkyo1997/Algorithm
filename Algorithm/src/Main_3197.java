import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_3197 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][] map = new char[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		bw.write(solve(map) + "\n");

		bw.flush();
		bw.close();
	}

	private static int solve(char[][] map) {
		int R = map.length;
		int C = map[0].length;
		int[][] ice = new int[R][C];
		int[][] visited = new int[R][C];
		int[] dx = { 0, 0, 1, -1 };
		int[] dy = { 1, -1, 0, 0 };
		int day = 1;
		int baejo = 0;
		int[] xList = new int[2];
		int[] yList = new int[2];

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'L') {
					xList[baejo] = i;
					yList[baejo++] = j;
				}
			}
		}
		while (true) {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] == 'X') {
						for (int d = 0; d < 4; d++) {
							int nx = i + dx[d];
							int ny = j + dy[d];
							if (nx < 0 || nx >= R || ny < 0 || ny >= C)
								continue;
							if (map[nx][ny] == 'X')
								continue;
							ice[i][j]++;
						}
					}
				}
			}
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (ice[i][j] >= 2)
						map[i][j] = '.';
				}
			}
			visited[xList[0]][yList[0]] = day;
			visited[xList[1]][yList[1]] = day;
			int[] qx = new int[R * C];
			int[] qy = new int[R * C];
			int front = 0;

			qx[front] = xList[0];
			qy[front++] = yList[0];
			qx[front] = xList[1];
			qy[front++] = yList[1];

			int rear = 2;
			while (front < rear) {
				int x = qx[front];
				int y = qy[front++];
				for (int d = 0; d < 4; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					if (nx < 0 || nx >= R || ny < 0 || ny >= C)
						continue;
					if (visited[nx][ny] == day)
						continue;
					if (map[nx][ny] == 'X')
						continue;
					visited[nx][ny] = day;
					qx[rear] = nx;
					qy[rear++] = ny;
				}
			}

			if (visited[xList[0]][yList[0]] == visited[xList[1]][yList[1]])
				break;
			day++;
		}
		return day - 1;
	}
}
