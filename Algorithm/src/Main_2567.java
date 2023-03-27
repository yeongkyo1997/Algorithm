import java.io.*;
import java.util.StringTokenizer;

public class Main_2567 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[][] paper = new int[101][101];
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int j = x; j < x + 10; j++)
                for (int k = y; k < y + 10; k++) paper[j][k] = 1;
        }

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (paper[i][j] == 1) {
                    for (int k : new int[]{paper[i + 1][j], paper[i][j + 1], paper[i - 1][j], paper[i][j - 1]}) {
                        if (k == 0) cnt++;
                    }
                }
            }
        }

        bw.write(cnt + "");
        bw.close();
    }
}
