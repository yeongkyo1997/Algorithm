import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_2567 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
<<<<<<< HEAD
        int[][] paper = new int[101][101];
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for (int j = x; j < x + 10; j++) {
                for (int k = y; k < y + 10; k++) {
                    paper[j][k] = 1;
                }
            }
        }

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (paper[i][j] == 1) {
                    if (paper[i + 1][j] == 0) cnt++;
                    if (paper[i][j + 1] == 0) cnt++;
                    if (paper[i - 1][j] == 0) cnt++;
                    if (paper[i][j - 1] == 0) cnt++;
                }
            }
        }

        bw.write(cnt + "");
=======
        int rMax = 0;
        int rMin = 101;
        int cMax = 0;
        int cMin = 101;

        while (N-- != 0) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            rMax = Math.max(rMax, r + 10);
            rMin = Math.min(rMin, r);
            cMax = Math.max(cMax, c + 10);
            cMin = Math.min(cMin, c);
        }

        int result = (rMax - rMin) * 2 + (cMax - cMin) * 2;
        bw.write(result + "\n");
>>>>>>> 8fcf9b03b4c4fb8d39a07423a5cf6515f36984b2
        bw.close();
    }
}
