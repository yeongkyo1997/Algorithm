import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int n, m;
    static int[] a, b;
    static int[] fail;
    static int[] smaller, bigger;

    static boolean isSame(int posA, int posB, int[] b) {
        if (smaller[posA] != -1 && b[posB - posA + smaller[posA]] >= b[posB]) return false;
        return bigger[posA] == -1 || b[posB - posA + bigger[posA]] > b[posB];
    }

    static void getPi() {
        fail = new int[n];
        smaller = new int[n];
        bigger = new int[n];

        int[] nxt = new int[n];
        int[] pre = new int[n];
        int[] pos = new int[n];

        IntStream.range(0, n).forEach(i -> {
            nxt[i] = i + 1;
            pre[i] = i - 1;
            pos[i] = n;
        });

        IntStream.range(0, n).forEach(i -> pos[a[i]] = Math.min(pos[a[i]], i));

        for (int i = n - 1; i >= 0; --i) {
            int v = a[i];
            if (nxt[v] == n) bigger[i] = -1;
            else bigger[i] = pos[nxt[v]];
            if (pre[v] == -1) smaller[i] = -1;
            else smaller[i] = pos[pre[v]];

            if (pre[v] != -1) nxt[pre[v]] = nxt[v];
            if (nxt[v] != n) pre[nxt[v]] = pre[v];
        }

        int j = 0;
        for (int i = 1; i < n; ++i) {
            while (j > 0 && !isSame(j, i, a)) {
                j = fail[j - 1];
            }
            if (isSame(j, i, a)) {
                fail[i] = j + 1;
                j++;
            }
        }
    }

    static void get() throws IOException {
        getPi();
        StringBuffer sb = new StringBuffer();
        int j = 0;
        int cnt = 0;
        for (int i = 0; i < m; ++i) {
            while (j > 0 && !isSame(j, i, b)) {
                j = fail[j - 1];
            }
            if (isSame(j, i, b)) {
                j++;
            }

            if (j == n) {
                sb.append((i - n + 2) + " ");
                cnt++;
                j = fail[j - 1];
            }
        }
        bw.write(cnt + "\n");
        bw.write(sb.toString());
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new int[n];
        b = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; ++i) {
            int v = Integer.parseInt(st.nextToken());
            a[v - 1] = i;
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; ++i) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        get();

        bw.close();
    }
}