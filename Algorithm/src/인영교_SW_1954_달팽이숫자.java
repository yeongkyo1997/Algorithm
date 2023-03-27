import java.io.*;
import java.util.StringTokenizer;

public class 인영교_SW_1954_달팽이숫자 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] list = new int[N][N];
            int num = 1;
            int x = 0;
            int y = 0;
            int dir = 0;
            int[] dx = {0, 1, 0, -1};
            int[] dy = {1, 0, -1, 0};

            while (num <= N * N) {
                list[x][y] = num;
                num++;
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N || list[nx][ny] != 0) {
                    dir = (dir + 1) % 4;
                }
                x += dx[dir];
                y += dy[dir];
            }

            bw.write("#" + t + "\n");

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    bw.write(list[i][j] + " ");
                }
                bw.write("\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
