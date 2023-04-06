import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.stream.IntStream;

public class Main_16946_벽_부수고_이동하기_4 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N, M;
    static int[][] map = new int[1000][1000];
    static int[][] areaNum = new int[1000][1000];
    static int zeroNum;
    static int[][] result = new int[1000][1000];

    static boolean[][] visited = new boolean[1000][1000];
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[] zeroSize = new int[1000000];

    static void input() throws Exception {

    }

    static void BFS(int a, int b) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(a, b));
        int Cnt = 1;
        areaNum[a][b] = zeroNum;
        visited[a][b] = true;

        while (!queue.isEmpty()) {
            int x = queue.peek().x;
            int y = queue.peek().y;
            queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (map[nx][ny] == 0 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        areaNum[nx][ny] = zeroNum;
                        queue.add(new Pair(nx, ny));
                        Cnt++;
                    }
                }
            }
        }
        zeroSize[zeroNum] = Cnt;
        zeroNum++;
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++)
                map[i][j] = str.charAt(j) - '0';
        }

        IntStream.range(0, 1000).forEach(i -> Arrays.fill(areaNum[i], -1));


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0 && !visited[i][j]) {
                    BFS(i, j);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    Set<Integer> Search = new HashSet<>();
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                            if (map[nx][ny] == 0) {
                                if (!Search.contains(areaNum[nx][ny])) {
                                    Search.add(areaNum[nx][ny]);
                                    result[i][j] = result[i][j] + zeroSize[areaNum[nx][ny]];
                                }
                            }
                        }
                    }
                    result[i][j] = result[i][j] + 1;
                    result[i][j] = result[i][j] % 10;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                bw.write(String.valueOf(result[i][j]));
            }
            bw.newLine();
        }
        bw.flush();
    }

    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}