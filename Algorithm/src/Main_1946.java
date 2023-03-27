import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

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
                list[i] = new int[]{a, b};
            }
            Arrays.sort(list, ((o1, o2) -> o2[0] - o1[0]));
            int cnt = 1;
            int min = list[0][1];

            cnt += IntStream.range(1, N).filter(i -> list[i][1] > min).count();

            bw.write(cnt + "\n");
        }
        bw.flush();
        bw.close();
    }
}
