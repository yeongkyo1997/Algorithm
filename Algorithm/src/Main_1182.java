import java.io.*;
import java.util.StringTokenizer;

import static java.util.stream.IntStream.range;

public class Main_1182 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] list;

        st = new StringTokenizer(br.readLine());
        list = range(0, N).map(i -> Integer.parseInt(st.nextToken())).toArray();
        int cnt = 0;
        for (int i = 1; i < (1 << N); i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                if ((i & 1 << j) == 0) continue;
                sum += list[j];
            }
            if (sum == S) cnt++;
        }
        bw.write(cnt + "");
        bw.close();
    }
}
