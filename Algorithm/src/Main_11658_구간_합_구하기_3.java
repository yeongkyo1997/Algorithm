import java.io.*;
import java.util.StringTokenizer;

public class Main_11658_구간_합_구하기_3 {
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

        data = new long[(N + 1) * (N + 1)];
        tree = new long[(N + 1) * (N + 1)];

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                data[i * N + j] = Long.parseLong(st.nextToken());
                update(i, data[i]);
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            long d = Long.parseLong(st.nextToken());

            if (a == 1) {
                update((long) b * N + c, d - data[(int) (b * N + c)]);
                data[(int) (b * N + c)] = d;
            } else {
                bw.write(getRange((long) b * N + c, d * N + d) + "\n");
            }
        }

        bw.close();
    }
}