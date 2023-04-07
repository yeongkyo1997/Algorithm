import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static long[] data;
    static long[] tree;

    static void update(long index, long value) {
        while (index < tree.length) {
            tree[(int) index] += value;
            index += (index & -index);
        }
    }

    static long sum(long index) {
        long result = 0;
        while (index > 0) {
            result += tree[(int) index];
            index -= (index & -index);
        }
        return result;
    }

    static long getRange(long start, long end) {
        return sum(end) - sum(start - 1);
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        data = new long[N + 1];
        tree = new long[N + 1];

        for (int i = 1; i <= N; i++) {
            data[i] = Long.parseLong(br.readLine());
            update(i, data[i]);
        }

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                update(b, c - data[b]);
                data[b] = c;
            } else {
                bw.write(getRange(b, c) + "\n");
            }
        }

        bw.close();
    }
}