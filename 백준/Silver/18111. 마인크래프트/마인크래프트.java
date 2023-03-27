import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N, M, B;
        int[][] list;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        list = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                list[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = Integer.MAX_VALUE;
        int height = 0;
        for (int i = 0; i < 257; i++) {
            int build = 0;
            int remove = 0;

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    int block = list[j][k] - i;
                    if (block > 0)
                        remove += block;
                    if (block < 0)
                        build -= block;
                }
            }

            if (B + remove >= build && time >= remove * 2 + build) {
                time = remove * 2 + build;
                height = i;
            }
        }
        bw.write(time + " " + height + "");
        bw.flush();
        bw.close();
    }
}
