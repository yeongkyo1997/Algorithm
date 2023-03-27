import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int[][][] graph;
    static int[][] dir = {{1, 0, 0}, {0, 1, 0}, {-1, 0, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};
    static int R, C, H;
    static Queue<int[]> q = new LinkedList<>();


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        graph = new int[H][R][C];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < R; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < C; k++) {
                    graph[i][j][k] = Integer.parseInt(st.nextToken());
                    if (graph[i][j][k] == 1) {
                        q.add(new int[]{j, k, i});
                    }
                }
            }
        }
        bfs();
    }

    static void bfs() throws IOException {
        int cnt = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            cnt++;
            for (int i = 0; i < size; i++) {
                int r = q.peek()[0];
                int c = q.peek()[1];
                int h = q.peek()[2];
                q.poll();
                for (int j = 0; j < 6; j++) {
                    int nr = r + dir[j][0];
                    int nc = c + dir[j][1];
                    int nh = h + dir[j][2];
                    if (nr >= 0 && nr < R && nc >= 0 && nc < C && nh >= 0 && nh < H && graph[nh][nr][nc] == 0) {
                        q.add(new int[]{nr, nc, nh});
                        graph[nh][nr][nc] = 1;
                    }
                }
            }
        }
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < R; j++) {
                for (int k = 0; k < C; k++) {
                    if (graph[i][j][k] == 0) {
                        bw.write(-1 + "");
                        bw.close();
                        return;
                    }
                }
            }
        }
        bw.write((cnt - 1) + "");
        bw.close();
    }
}