import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int N, K;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        boolean[] prime = new boolean[1001];
        Arrays.fill(prime, true);

        prime[0] = prime[1] = false;

        for (int i = 2; i <= N; i++) {
            if (prime[i]) {
                for (int j = i; j <= N; j += i) {
                    if (prime[j]) {
                        prime[j] = false;
                        K--;
                        if (K == 0) {
                            bw.write(String.valueOf(j));
                            bw.flush();
                            System.exit(0);
                        }
                    }
                }
            }
        }
    }
}