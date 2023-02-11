import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1946 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        while (T-- != 0) {
            int N = Integer.parseInt(br.readLine());
            int[][] list = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list[i] = new int[] { a, b };
            }
            Arrays.sort(list, ((o1, o2) -> o2[0] - o1[0]));
            int cnt = 1;
            int min = list[0][1];

            for (int i = 1; i < N; i++) {
                if (list[i][1] > min) {
                    cnt++;
                }
            }

            bw.write(cnt + "\n");
        }
        bw.flush();
        bw.close();
    }
}
