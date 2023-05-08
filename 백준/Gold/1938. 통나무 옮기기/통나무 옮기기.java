import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static char[][] map;
    static Node[] list1, list2;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    static class Node {
        int x, y, dir, dist;

        Node(int x, int y, int dir, int dist) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.dist = dist;
        }

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        list1 = new Node[3];
        list2 = new Node[3];

        int b = 0, e = 0;
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'B') list1[b++] = new Node(i, j);
                if (map[i][j] == 'E') list2[e++] = new Node(i, j);
            }
        }
        bw.write(bfs() + "\n");
        bw.close();
    }

    private static int bfs() {
        boolean[][][] visited = new boolean[2][N][N];
        Queue<Node> queue = new LinkedList<>();

        int dir;
        if (list1[0].y + 1 == list1[1].y) dir = 0;
        else dir = 1;

        queue.add(new Node(list1[1].x, list1[1].y, dir, 0));
        visited[dir][list1[1].x][list1[1].y] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.x == list2[1].x & cur.y == list2[1].y) {
                if (cur.dir == 0 && map[cur.x][cur.y - 1] == 'E' && map[cur.x][cur.y + 1] == 'E' || cur.dir == 1 && map[cur.x - 1][cur.y] == 'E' && map[cur.x + 1][cur.y] == 'E') {
                    return cur.dist;
                }
            }

            for (int i = 0; i < 4; i++) {
                int x = cur.x + dx[i];
                int y = cur.y + dy[i];

                if (cur.dir == 0) {
                    if (!checkCol(x, y, i)) continue;
                } else {
                    if (!checkRow(x, y, i)) continue;
                }

                if (visited[cur.dir][x][y]) continue;

                visited[cur.dir][x][y] = true;
                queue.add(new Node(x, y, cur.dir, cur.dist + 1));
            }

            if (isRot(cur.x, cur.y)) {
                if (cur.dir == 0 && !visited[1][cur.x][cur.y]) {
                    visited[1][cur.x][cur.y] = true;
                    queue.add(new Node(cur.x, cur.y, 1, cur.dist + 1));
                } else if (cur.dir == 1 && !visited[0][cur.x][cur.y]) {
                    visited[0][cur.x][cur.y] = true;
                    queue.add(new Node(cur.x, cur.y, 0, cur.dist + 1));
                }
            }

        }

        return 0;
    }

    private static boolean checkRow(int x, int y, int direction) {

        if (direction < 2) {
            if (x - 1 < 0 || x + 1 >= N) return false;
        } else if (y < 0 || y >= N) return false;
        return map[x][y] != '1' && map[x - 1][y] != '1' && map[x + 1][y] != '1';
    }

    private static boolean checkCol(int x, int y, int d) {

        if (d < 2) {
            if (x < 0 || x >= N) return false;
        } else if (y - 1 < 0 || y + 1 >= N) return false;
        return map[x][y] != '1' && map[x][y - 1] != '1' && map[x][y + 1] != '1';
    }

    private static boolean isRot(int x, int y) {
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i < 0 || j < 0 || i >= N || j >= N || map[i][j] == '1') return false;
            }
        }

        return true;
    }

}