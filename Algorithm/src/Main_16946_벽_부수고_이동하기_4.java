import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_16946_벽_부수고_이동하기_4 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int n, m;
    static int[][] graph;
    static boolean[][] visited;
    static int[][] zeros;
    static int group = 1;
    static int[] info;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        visited = new boolean[n][m];
        zeros = new int[n][m];
        info = new int[n * m];
        info[0] = 0;

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            Arrays.setAll(graph[i], j -> str.charAt(j) - '0');
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 0 && !visited[i][j]) {
                    visited[i][j] = true;

                    int w = bfs(i, j);
                    info[group] = w;
                    group++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 1) {
                    int sum = 1;
                    boolean[] check = new boolean[group];

                    for (int idx = 0; idx < 4; idx++) {
                        int ni = i + dy[idx];
                        int nj = j + dx[idx];
                        if (ni < 0 || ni >= n || nj < 0 || nj >= m) continue;
                        if (!check[zeros[ni][nj]]) {
                            sum += info[zeros[ni][nj]];
                            check[zeros[ni][nj]] = true;
                        }
                    }
                    graph[i][j] = sum % 10;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                bw.write(String.valueOf(graph[i][j]));
            bw.write("\n");
        }
        bw.close();
    }

    static int bfs(int i, int j) {
        int cnt = 1;
        int[] queue = new int[n * m];
        int front = -1;
        int rear = -1;

        queue[++rear] = i;
        queue[++rear] = j;

        while (front != rear) {
            i = queue[++front];
            j = queue[++front];

            zeros[i][j] = group;
            for (int idx = 0; idx < 4; idx++) {
                int ni = i + dy[idx];
                int nj = j + dx[idx];
                if (ni < 0 || ni >= n || nj < 0 || nj >= m || visited[ni][nj] || graph[ni][nj] == 1) continue;

                visited[ni][nj] = true;
                queue[++rear] = ni;
                queue[++rear] = nj;
                cnt++;
            }
        }
        return cnt;
    }
}
