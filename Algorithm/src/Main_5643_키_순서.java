import java.io.*;
import java.util.StringTokenizer;

public class Main_5643_키_순서 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int n, m;
            n = Integer.parseInt(br.readLine());
            m = Integer.parseInt(br.readLine());

            int[][] map = new int[n + 1][n + 1];
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                map[a][b] = 1;
            }

            for (int k = 1; k <= n; k++) {
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= n; j++) {
                        if (map[i][k] == 1 && map[k][j] == 1) {
                            map[i][j] = 1;
                        }
                    }
                }
            }

            int result = 0;

            for (int i = 1; i <= n; i++) {
                int cnt = 0;
                for (int j = 1; j <= n; j++) {
                    if (map[i][j] == 1 || map[j][i] == 1) {
                        cnt++;
                    }
                }
                if (cnt == n - 1) {
                    result++;
                }
            }

            bw.write(String.format("#%d %d\n", t + 1, result));
        }
        bw.close();
    }
}
