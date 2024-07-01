import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N, M;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int[][] board;
	static int[][] cpBoard;
	static ArrayList<int[]> virus = new ArrayList<>();
	static int result = 0;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		cpBoard = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 2) {
					virus.add(new int[] { i, j });
				}
			}
		}

		dfs(0);

		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}

	// 연구소 복사
	static void labCopy() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				cpBoard[i][j] = board[i][j];
			}
		}
	}

	// 안전 영역 개수
	static int safeCnt() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (cpBoard[i][j] == 0) {
					cnt++;
				}
			}
		}
		return cnt;
	}

	// 벽 설치
	static void dfs(int depth) {
		if (depth == 3) {
			labCopy();
			bfs();
			return;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 0) {
					board[i][j] = 1;
					dfs(depth + 1);
					board[i][j] = 0;
				}
			}
		}
	}

	// 바이러스 퍼뜨리기
	static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		for (int[] ele : virus) {
			queue.offer(ele);
		}

		while (!queue.isEmpty()) {
			int[] poll = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = poll[0] + dx[i];
				int ny = poll[1] + dy[i];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;

				if (cpBoard[nx][ny] == 1 || cpBoard[nx][ny] == 2)
					continue;

				cpBoard[nx][ny] = 2;
				queue.offer(new int[] { nx, ny });
			}
		}
		result = Math.max(result, safeCnt());
	}
}