import java.io.*;
import java.util.StringTokenizer;

import static java.util.stream.IntStream.range;

public class Main_1939 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[] a = new int[N];
        int[] b = new int[N];
        int[] c = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 1000000000;
        int mid;
        int result = 0;

        while (left <= right) {
            mid = (left + right) / 2;
            if (check(a, b, c, mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        bw.write(result + "");
        bw.close();
    }

    public static boolean check(int[] a, int[] b, int[] c, int mid) {
        int[] d = new int[N];
        for (int i = 0; i < N; i++) {
            if (mid >= a[i]) d[i] = c[i];
        }
        int[] e = new int[N];

        range(0, N).filter(i -> mid >= b[i]).forEach(i -> e[i] = c[i]);

        int[] f = range(0, N).map(i -> d[i] - e[i]).toArray();

        int[] g = new int[N];
        range(0, N).forEach(i -> g[i] = i == 0 ? f[i] : g[i - 1] + f[i]);

        int[] h = new int[N];
        range(0, N).forEach(i -> h[i] = i == 0 ? g[i] : Math.max(h[i - 1], g[i]));

        int[] i = new int[N];
        range(0, N).forEach(j -> i[j] = j == 0 ? h[j] : Math.max(i[j - 1], h[j]));

        return i[N - 1] >= M;
    }
}
