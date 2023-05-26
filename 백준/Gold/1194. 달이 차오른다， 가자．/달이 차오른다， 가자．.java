import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Position {
    int x, y;
    int count, key;

    public Position(int x, int y, int count, int key) {
        this.x = x;
        this.y = y;
        this.count = count;
        this.key = key;
    }
}

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static final int MAX = 50;
    static char[][] MAP = new char[MAX][MAX];
    static boolean[][][] visit = new boolean[MAX][MAX][1 << 6];
    static int N, M;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static Position start;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                MAP[i][j] = input.charAt(j);
                if (MAP[i][j] == '0') {
                    start = new Position(i, j, 0, 0);
                    MAP[i][j] = '.';
                }
            }
        }

        int result = bfs(start);
        bw.write(String.valueOf(result));
        bw.close();
    }

    private static boolean haveThisKey(int current_key, char door) {
        int R_value = current_key & (1 << (door - 'A'));
        return R_value != 0;
    }

    private static int bfs(Position start) {
        Queue<Position> queue = new LinkedList<>();
        queue.offer(start);
        visit[start.x][start.y][0] = true;

        while (!queue.isEmpty()) {
            Position cur = queue.poll();
            int x = cur.x;
            int y = cur.y;
            int count = cur.count;
            int key = cur.key;

            if (MAP[x][y] == '1') return count;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (!visit[nx][ny][key]) {
                        if (MAP[nx][ny] == '.' || MAP[nx][ny] == '1') {
                            visit[nx][ny][key] = true;
                            queue.offer(new Position(nx, ny, count + 1, key));
                        } else if ('a' <= MAP[nx][ny] && MAP[nx][ny] <= 'f') {
                            int tmp_key = key | (1 << (MAP[nx][ny] - 'a'));
                            visit[nx][ny][tmp_key] = true;
                            queue.offer(new Position(nx, ny, count + 1, tmp_key));
                        } else if ('A' <= MAP[nx][ny] && MAP[nx][ny] <= 'F') {
                            if (haveThisKey(key, MAP[nx][ny])) {
                                visit[nx][ny][key] = true;
                                queue.offer(new Position(nx, ny, count + 1, key));
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }
}