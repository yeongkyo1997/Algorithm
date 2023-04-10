//import java.io.*;
//import java.util.Arrays;
//import java.util.PriorityQueue;
//import java.util.StringTokenizer;
//
//public class Main_1261_알고스팟 {
//    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//    static StringTokenizer st;
//    static int N, M;
//    static int[][] arr;
//    static int[][] dist;
//    static int[] dx = {0, 0, -1, 1};
//    static int[] dy = {-1, 1, 0, 0};
//
//    static class Node implements Comparable<Node> {
//        int x, y, cost;
//
//        public Node(int x, int y, int cost) {
//            this.x = x;
//            this.y = y;
//            this.cost = cost;
//        }
//
//        @Override
//        public int compareTo(Node o) {
//            return cost - o.cost;
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//        st = new StringTokenizer(br.readLine());
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//        arr = new int[N][M];
//
//    }
//
//    static void dijkstra() {
//        dist = new int[N][M];
//        for (int i = 0; i < N; i++) {
//            Arrays.fill(dist[i], Integer.MAX_VALUE);
//        }
//
//        PriorityQueue<Node> pq = new PriorityQueue<>();
//
//        pq.add(new Node(0, 0, 0));
//
//        while (!pq.isEmpty()) {
//            Node cur = pq.poll();
//
//            if (cur.cost > dist[cur.x][cur.y]) continue;
//            for (int i = 0; i < 4; i++) {
//                int nx = cur.x + dx[i];
//                int ny = cur.y + dy[i];
//
//                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
//                    if (dist[nx][ny] >)
//                }
//            }
//        }
//    }
//}