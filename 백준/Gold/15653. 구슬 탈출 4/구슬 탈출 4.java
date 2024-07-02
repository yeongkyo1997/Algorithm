import java.io.*;
import java.util.*;

class Item {
	int rx, ry;
	int bx, by;
	int depth;

	public Item(int rx, int ry, int bx, int by, int depth) {
		this.rx = rx;
		this.ry = ry;
		this.bx = bx;
		this.by = by;
		this.depth = depth;
	}

	@Override
	public String toString() {
		return rx + "," + ry + "," + bx + "," + by;
	}
}

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N, M;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int[][] map;
	static boolean[][][][] visited;
	static int rx, ry, bx, by;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M][N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'R') {
					rx = i;
					ry = j;
				} else if (map[i][j] == 'B') {
					bx = i;
					by = j;
				}
			}
		}

		bw.write(bfs() + "");
		bw.close();
	}

	// 구슬 움직이기
	static int[] move(int x, int y, int direction) {
		int cnt = 0;
		while (map[x + dx[direction]][y + dy[direction]] != '#' && map[x][y] != 'O') {
			x += dx[direction];
			y += dy[direction];
			cnt++;
		}
		return new int[] { x, y, cnt };
	}

	// bfs 판 기울이기
	static int bfs() {
		Queue<Item> queue = new ArrayDeque<>();
		queue.offer(new Item(rx, ry, bx, by, 1));
		visited[rx][ry][bx][by] = true;

		while (!queue.isEmpty()) {
			Item poll = queue.poll();

			for (int i = 0; i < 4; i++) {
				// 파란색 움직이기
				int[] blue = move(poll.bx, poll.by, i);

				// 빨간색 움직이기
				int[] red = move(poll.rx, poll.ry, i);

				// 파란색 도착 확인
				if (map[blue[0]][blue[1]] == 'O') {
					continue;
				} else {
					// 빨간색 도착
					if (map[red[0]][red[1]] == 'O') {
						return poll.depth;
					} else {
						if (red[0] == blue[0] && red[1] == blue[1]) {
							if (red[2] > blue[2]) {
								red[0] -= dx[i];
								red[1] -= dy[i];
							} else {
								blue[0] -= dx[i];
								blue[1] -= dy[i];
							}
						}
						Item item = new Item(red[0], red[1], blue[0], blue[1], poll.depth + 1);

						if (visited[item.rx][item.ry][item.bx][item.by]) {
							continue;
						}

						visited[item.rx][item.ry][item.bx][item.by] = true;
						queue.offer(item);
					}
				}

			}
		}
		return -1;
	}
}