import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// SWEA 2001. 파리 퇴치
public class Solution_2001 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N, M;
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int[][] map = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int si = 0;
            int sj = 0;
            int ei = M - 1;
            int ej = M - 1;
            int tmp = 0;
            while (ei < N) {
                while (ej < N) {
                    tmp = 0;
                    for (int i = si; i <= ei; i++) {
                        for (int j = sj; j <= ej; j++) {
                            tmp += map[i][j];
                        }
                    }
                    result = Math.max(result, tmp);
                    sj++;
                    ej++;
                }
                si++;
                ei++;
                sj = 0;
                ej = M - 1;
            }
            bw.write("#" + tc + " " + result + "\n");
            result = 0;
        }
        bw.close();
    }
}