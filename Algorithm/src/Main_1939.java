import java.io.*;
import java.util.StringTokenizer;

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
        int mid = 0;
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
            if (mid >= a[i]) {
                d[i] = c[i];
            }
        }
        int[] e = new int[N];
        for (int i = 0; i < N; i++) {
            if (mid >= b[i]) {
                e[i] = c[i];
            }
        }
        int[] f = new int[N];
        for (int i = 0; i < N; i++) {
            f[i] = d[i] - e[i];
        }
        int[] g = new int[N];
        for (int i = 0; i < N; i++) {
            if (i == 0) {
                g[i] = f[i];
            } else {
                g[i] = g[i - 1] + f[i];
            }
        }
        int[] h = new int[N];
        for (int i = 0; i < N; i++) {
            if (i == 0) {
                h[i] = g[i];
            } else {
                h[i] = Math.max(h[i - 1], g[i]);
            }
        }
        int[] i = new int[N];
        for (int j = 0; j < N; j++) {
            if (j == 0) {
                i[j] = h[j];
            } else {
                i[j] = Math.max(i[j - 1], h[j]);
            }
        }
        if (i[N - 1] >= M) {
            return true;
        } else {
            return false;
        }
    }
}
