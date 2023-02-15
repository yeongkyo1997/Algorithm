import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_9229 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            Integer[] list = new Integer[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                list[i] = Integer.parseInt(st.nextToken());
            }

            int result = -1;
            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    int i1 = list[i] + list[j];

                    if (i1 <= M && result < i1) {
                        result = i1;
                    }
                }
            }
            bw.write("#" + (t + 1) + " " + result + "\n");
        }
        bw.close();
    }
}