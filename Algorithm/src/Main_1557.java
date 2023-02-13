import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1557 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int MAX = 100001;
    static int[] list = new int[MAX + 1];

    static long solve(long N) {
        long result = 0;
        for (int i = 1; (long) i * i < N + 1; i++) {
            result += list[i] * (N / ((long) i * i));
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        int K;
        K = Integer.parseInt(br.readLine());

        Arrays.fill(list, 1);

        for (int i = 2; i * i < MAX + 1; i++) {
            if (list[i] == 1) {
                for (int j = i; j < MAX + 1; j += i)
                    list[j] *= -i;
                for (int j = i * i; j < MAX + 1; j += i * i)
                    list[j] = 0;
            }
        }

        for (int i = 2; i < MAX + 1; i++) {
            if (list[i] == i) list[i] = 1;
            else if (list[i] == -i) list[i] = -1;
            else if (list[i] < 0) list[i] = 1;
            else if (list[i] > 0) list[i] = -1;
        }

        long start = 1;
        long end = 2000000000;
        while (start < end) {
            long mid = (start + end) >> 1;
            long tmp = solve(mid);
            if (tmp > K) end = mid - 1;
            else if (tmp == K) end = mid;
            else start = mid + 1;
        }

        bw.write(start + "");
        bw.close();
    }
}