//import java.io.*;
//import java.util.*;
//
//public class Main_14502_연구소 {
//    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//    static StringTokenizer st;
//    static int N, M;
//    static List<int[]> list = new ArrayList<>();
//    static int[][] map;
//    static boolean[][] visited;
//    static int[][] copy;
//    static Queue<int[]> queue;
//    static int[] virus;
//    static int result = 0;
//    static int[] dx = {0, 0, -1, 1};
//    static int[] dy = {-1, 1, 0, 0};
//
//    public static void main(String[] args) throws IOException {
//        st = new StringTokenizer(br.readLine());
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//
//        map = new int[N][M];
//        visited = new boolean[N][M];
//
//        for (int i = 0; i < N; i++) {
//            st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < M; j++) {
//                map[i][j] = Integer.parseInt(st.nextToken());
//                if (map[i][j] == 0) list.add(new int[]{i, j});
//            }
//        }
//    }
//
//    static void dfs(int start, int depth) {
//        if (depth == 3) {
//            queue = new ArrayDeque<>();
//            visited = new boolean[N][M];
//
//            for (int i : virus) {
//                queue.add(list.get(i));
//                visited[list.get(i)[0]][list.get(i)[1]] = true;
//            }
//            result = Math.max(result, bfs());
//            return;
//        }
//
//        for (int i = start; i < list.size(); i++) {
//            virus[depth] = i;
//            dfs(i + 1, depth + 1);
//        }
//    }
//
//    static int bfs() {
//        while (!queue.isEmpty()) {
//            int[] cur = queue.poll();
//
//            for (int i = 0; i < 4; i++) {
//                int nx = cur[0] + dx[i];
//                int ny = cur[1] + dy[i];
//
//                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {
//                }
//            }
//        }
//    }
//
//    static void copyMap() {
//        for (int i = 0; i < N; i++) {
//            if (M >= 0) System.arraycopy(copy[i], 0, map[i], 0, M);
//        }
//    }
//}
