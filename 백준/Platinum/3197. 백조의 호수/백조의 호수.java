import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int r, c, lx, ly, cnt;
    static final int MX = 1502;
    static char[][] board = new char[MX][MX];
    static int[][] vis = new int[MX][MX];
    static int[][] visited = new int[MX][MX];
    static boolean isPossible = false;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static boolean OutOfBound(int a, int b) {
        return a < 0 || a >= r || b < 0 || b >= c;
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                board[i][j] = str.charAt(j);
                if (board[i][j] == 'L') {
                    lx = i;
                    ly = j;
                }
                if (board[i][j] != 'X') q.push(new Pair(i, j));
            }
        }
        lq.push(new Pair(lx, ly));
        board[lx][ly] = '.';
        vis[lx][ly] = 1;
        while (!isPossible) {
            while (!q.empty()) {
                Pair cur = q.pop();
                visited[cur.x][cur.y] = 1;
                for (int dir = 0; dir < 4; dir++) {
                    int nx = cur.x + dx[dir];
                    int ny = cur.y + dy[dir];
                    if (OutOfBound(nx, ny)) continue;
                    if (visited[nx][ny] == 1) continue;
                    if (board[nx][ny] == 'X') q2.push(new Pair(nx, ny));
                    visited[nx][ny] = 1;
                }
            }
            while (!q2.empty()) {
                Pair cur = q2.pop();
                board[cur.x][cur.y] = '.';
                q.push(new Pair(cur.x, cur.y));
            }
            cnt++;
            while (!lq.empty()) {
                Pair cur = lq.pop();
                for (int dir = 0; dir < 4; dir++) {
                    int nx = cur.x + dx[dir];
                    int ny = cur.y + dy[dir];
                    if (OutOfBound(nx, ny)) continue;
                    if (vis[nx][ny] == 1) continue;
                    if (board[nx][ny] == 'X') {
                        vis[nx][ny] = 1;
                        lq2.push(new Pair(nx, ny));
                        continue;
                    } else if (board[nx][ny] == 'L') {
                        isPossible = true;
                        break;
                    }

                    vis[nx][ny] = 1;
                    lq.push(new Pair(nx, ny));
                }
            }
            while (!lq2.empty()) {
                Pair cur = lq2.pop();
                lq.push(new Pair(cur.x, cur.y));
            }
        }
        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
    }

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Queue {
        Pair[] arr = new Pair[MX * MX];
        int front, rear;

        public Queue() {
            front = rear = 0;
        }

        public void push(Pair p) {
            arr[rear++] = p;
        }

        public Pair pop() {
            return arr[front++];
        }

        public boolean empty() {
            return front == rear;
        }
    }

    static Queue q = new Queue();
    static Queue q2 = new Queue();
    static Queue lq = new Queue();
    static Queue lq2 = new Queue();
}