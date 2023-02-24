import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_16236 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[][] map;
    static int N;
    static int sharkX;
    static int sharkY;
    static int sharkSize;
    static int sharkEat;
    static int result;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    static boolean[][] visited;
    static int[][] dist;
    static int minDist;
    static int minX;
    static int minY;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        sharkSize = 2;
        sharkEat = 0;
        result = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    sharkX = i;
                    sharkY = j;
                    map[i][j] = 0;
                }
            }
        }
        while (true) {
            visited = new boolean[N][N];
            dist = new int[N][N];
            minDist = Integer.MAX_VALUE;
            minX = Integer.MAX_VALUE;
            minY = Integer.MAX_VALUE;
            bfs(sharkX, sharkY);
            if (minDist == Integer.MAX_VALUE) {
                break;
            }
            result += minDist;

            map[minX][minY] = 0;
            sharkX = minX;
            sharkY = minY;
            sharkEat++;
            if (sharkEat == sharkSize) {
                sharkSize++;
                sharkEat = 0;
            }
        }
        bw.write(result + "");
        bw.flush();
        bw.close();
    }

    static void bfs(int x, int y) {
        visited[x][y] = true;
        dist[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                continue;
            }
            if (visited[nx][ny]) {
                continue;
            }
            if (map[nx][ny] > sharkSize) {
                continue;
            }
            visited[nx][ny] = true;
            dist[nx][ny] = dist[x][y] + 1;
            if (map[nx][ny] != 0 && map[nx][ny] < sharkSize) {
                if (minDist > dist[nx][ny]) {
                    minDist = dist[nx][ny];
                    minX = nx;
                    minY = ny;
                } else if (minDist == dist[nx][ny]) {
                    if (minX > nx) {
                        minX = nx;
                        minY = ny;
                    } else if (minX == nx) {
                        if (minY > ny) {
                            minY = ny;
                        }
                    }
                }
            }
            bfs(nx, ny);
        }
    }
}