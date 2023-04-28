import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;


    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int F = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] arr = new long[M + 1];
        boolean[] prime = new boolean[M + 1];
        prime[0] = prime[1] = false;

        IntStream.range(2, M + 1).forEach(i -> prime[i] = true);

        for (int i = 2; i < Math.sqrt(M + 1); i++) {
            if (prime[i]) {
                for (int j = 2 * i; j < M + 1; j += i) prime[j] = false;
            }
        }
        long[] primeList = new long[M + 1];
        int idx = 0;

        for (int i = 0; i < M + 1; i++) {
            if (prime[i]) primeList[idx++] = i;
        }
        IntStream.range(0, idx).forEach(i -> {
            try {
                arr[i] = ps(S + F, primeList[i]) - ps(F, primeList[i]) - ps(S, primeList[i]);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        bw.write(check(M, arr, primeList) + "\n");
        bw.close();
    }

    static long ps(int n, long r) throws IOException {
        long tmp = r;
        long cnt = 0;

        while (n >= tmp) {
            try {
                cnt += n / tmp;
            } catch (Exception e) {
                bw.write(-1);
                bw.close();
                System.exit(0);
            }
            tmp *= r;
        }
        return cnt;
    }

    static long check(int M, long[] arr, long[] primeList) throws IOException {
        for (int i = M; i > 0; i--) {
            long tmp = i;
            int idx = 0;
            int cnt = 0;

            boolean flag = true;

            while (tmp > 1) {
                if (tmp % primeList[idx] == 0) {
                    try {
                        tmp /= primeList[idx];
                    } catch (Exception e) {
                        bw.write(-1);
                        bw.close();
                        System.exit(0);
                    }
                    cnt += 1;

                    if (cnt > arr[idx]) {
                        flag = false;
                        break;
                    }
                } else {
                    cnt = 0;
                    idx += 1;
                }
            }
            if (flag) return i;
        }
        return -1;
    }
}