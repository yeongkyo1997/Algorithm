import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// BOJ 1046 그림자
public class Main_1046 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == '#') {
                    result += 4;
                    if (i > 0 && map[i - 1][j] == '#') {
                        result--;
                    }
                    if (i < N - 1 && map[i + 1][j] == '#') {
                        result--;
                    }
                    if (j > 0 && map[i][j - 1] == '#') {
                        result--;
                    }
                    if (j < M - 1 && map[i][j + 1] == '#') {
                        result--;
                    }
                }
            }
        }
        bw.write(result + "");
        bw.flush();
        bw.close();
    }
}
