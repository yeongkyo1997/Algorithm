import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;


    static int N, M;
    static int[][] lab; // 연구소
    static int[][] visited; // 바이러스가 퍼진 시간
    static boolean[][] check; // 바이러스 선택 여부
    static int[] virus; // 바이러스 위치
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int result = 987654321;

    static boolean spread() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (lab[i][j] != 1 && visited[i][j] == -1) return false; // 빈칸이 있으면 false
            }
        }
        return true;
    }

    static int bfs() {
        Queue<Integer> queue = new LinkedList<>();

        int ret = 0;
        visited = new int[N][N];

        for (int i = 0; i < N; i++)
            Arrays.fill(visited[i], -1); // -1로 초기화

        for (int virus : virus) {
            int x = virus / N; // 바이러스 위치 
            int y = virus % N; // 바이러스 위치
            queue.add(virus);
            visited[x][y] = 0;
        }

        while (!queue.isEmpty()) {
            int x = queue.peek() / N; // 바이러스 위치
            int y = queue.peek() % N; // 바이러스 위치
            queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                if (lab[nx][ny] != 1 && visited[nx][ny] == -1) {
                    visited[nx][ny] = visited[x][y] + 1;
                    ret = visited[nx][ny];
                    queue.add(nx * N + ny);
                }
            }
        }
        return ret;
    }

    static void dfs(int x, int y, int cnt) {
        if (cnt == M) {
            int res = bfs();
            if (spread()) result = Math.min(result, res); // 모든 빈칸에 바이러스가 퍼졌으면 최소 시간 갱신
            return;
        }

        for (int i = x; i < N; i++) { // 바이러스 선택
            for (int j = y; j < N; j++) {
                if (lab[i][j] != 2 || check[i][j]) continue; // 바이러스가 아니거나 이미 선택된 바이러스면 continue
                check[i][j] = true;
                virus[cnt] = i * N + j; // 바이러스 위치 저장
                dfs(i, j, cnt + 1);
                check[i][j] = false;
            }
            y = 0;
        }
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lab = new int[N][N];
        check = new boolean[N][N];
        virus = new int[M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                lab[i][j] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0, 0);
        if (result == 987654321) result = -1; // 모든 빈칸에 바이러스가 퍼지지 않았으면 -1
        bw.write(result + "\n");
        bw.close();
    }
}