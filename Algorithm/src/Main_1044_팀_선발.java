import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main_1044_팀_선발 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int n;
    static long res = Long.MAX_VALUE;
    static int[] d1 = new int[36];
    static int[] d2 = new int[36];
    static int[] cur = new int[36];
    static int[] r2 = new int[36];

    static void bt(int idx, long gap) {
        if (idx == n >> 1) {
            if (res >= Math.abs(gap)) {
                if (res > Math.abs(gap)) {
                    res = Math.abs(gap);
                    if (n >> 1 >= 0) System.arraycopy(cur, 0, r2, 0, n / 2);
                }
            }
            return;
        }
        cur[idx] = 1;
        bt(idx + 1, gap + d1[idx]);
        cur[idx] = 2;
        bt(idx + 1, gap - d2[idx]);
    }

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        IntStream.range(0, n).forEach(i -> d1[i] = Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        IntStream.range(0, n).forEach(i -> d2[i] = Integer.parseInt(st.nextToken()));

        bt(0, 0);

        for (int i = 0; i < n; ++i) bw.write(r2[i] + " ");
        bw.close();
    }
}
