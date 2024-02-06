import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int cnt = 0;

    static int N;
    static int[][] list;
    static ArrayList<Integer> result = new ArrayList<>();

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        list = new int[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                list[i][j] = str.charAt(j) - '0';
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (list[i][j] == 1) {
                    cnt++;
                    result.add(bfs(i, j));
                }
            }
        }
        bw.write(cnt + "\n");
        Collections.sort(result);

        for (int i = 0; i < result.size(); i++) {
            bw.write(result.get(i) + "\n");
        }
        bw.flush();
        bw.close();
    }


    static int bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        list[x][y] = 0;
        int res = 1;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && list[nx][ny] == 1) {
                    list[nx][ny] = 0;
                    queue.add(new Node(nx, ny));
                    res++;
                }
            }
        }
        return res;
    }
}