import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int M, N;
    static int[][] arr;
    static int[][] distance;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        distance = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j) - '0';
                distance[i][j] = Integer.MAX_VALUE;
            }
        }

        dijkstra();
        bw.write(distance[N - 1][M - 1] + "\n");
        bw.flush();
        bw.close();
    }

    static void dijkstra() {
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(0, 0, 0));
        distance[0][0] = 0;

        while (!q.isEmpty()) {
            Node node = q.poll();
            int cost = node.cost;
            int r = node.x;
            int c = node.y;
            if (cost > distance[r][c]) continue;

            for (int i = 0; i < 4; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;

                if (cost + arr[nr][nc] < distance[nr][nc]) {
                    distance[nr][nc] = cost + arr[nr][nc];
                    q.add(new Node(distance[nr][nc], nr, nc));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int cost;
        int x;
        int y;

        public Node(int cost, int x, int y) {
            this.cost = cost;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}