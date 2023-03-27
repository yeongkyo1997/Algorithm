import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2468 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean visited[][];
    static int[][] num;
    static int cnt, ans, tmp;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        cnt = Integer.parseInt(br.readLine());
        num = new int[cnt][cnt];
        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < cnt; j++) num[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int k = 1; k <= 100; k++) {
            visited = new boolean[cnt][cnt];
            tmp = 0;

            for (int i = 0; i < cnt; i++) {
                for (int j = 0; j < cnt; j++) {
                    if (num[i][j] > k && !visited[i][j]) {
                        tmp++;
                        hong(i, j, k);
                    }
                }
            }
            ans = Math.max(ans, tmp);
        }

        bw.write(ans + "");
        bw.flush();
        bw.close();

    }

    private static void hong(int x, int y, int k) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] pos = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = pos[0] + dx[d];
                int ny = pos[1] + dy[d];

                if (nx < 0 || nx >= cnt || ny < 0 || ny >= cnt || num[nx][ny] <= k || visited[nx][ny]) continue;

                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny});
            }
        }
    }
}