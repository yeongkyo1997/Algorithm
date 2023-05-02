import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N, K;
    static int[][] arr;
    static int[] size;

    static boolean kmp(int idx, int[] virus, int[] pi) {
        int p = 0;
        for (int i = 0; i < size[idx]; i++) {
            while (arr[idx][i] != virus[p] && p > 0) p = pi[p - 1];
            if (arr[idx][i] == virus[p]) p++;
            if (p == K) return true;
        }
        return false;
    }

    static void getPi(int[] virus, int[] pi) {
        int p = 0;
        for (int i = 1; i < K; i++) {
            while (virus[i] != virus[p] && p > 0) p = pi[p - 1];
            if (virus[p] == virus[i]) pi[i] = ++p;
        }
    }

    static boolean findVirus() {
        for (int i = 0; i < size[0]; i++) {
            if (i >= K - 1) {
                int[] virus = new int[K];
                int[] revVirus = new int[K];
                for (int j = 0; j < K; j++) {
                    virus[j] = arr[0][i - j];
                    revVirus[j] = virus[j];
                }
                reverse(revVirus);
                int[] pi = new int[K];
                int[] revPi = IntStream.range(0, K).map(j -> pi[j] = 0).toArray();
                getPi(virus, pi);
                getPi(revVirus, revPi);
                int cnt = 1;
                for (int j = 1; j < N; j++) {
                    if (kmp(j, virus, pi) || kmp(j, revVirus, revPi)) cnt++;
                    else break;
                }
                if (cnt == N) return true;
            }
        }
        return false;
    }


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][];
        size = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            size[i] = M;
            arr[i] = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        bw.write((findVirus() ? "YES" : "NO") + "\n");
        bw.close();
    }

    static void reverse(int[] arr) {
        int[] tmp = new int[arr.length];
        System.arraycopy(arr, 0, tmp, 0, arr.length);
        IntStream.range(0, arr.length).forEach(i -> arr[i] = tmp[arr.length - 1 - i]);
    }
}