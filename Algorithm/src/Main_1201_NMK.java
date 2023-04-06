import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main_1201_NMK {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] arr = new int[503];

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if (n >= m + k - 1 && n <= m * k) {
            IntStream.range(0, n).forEach(i -> arr[i] = i + 1);

            int idx = 0;

            for (int i = 1; i <= m; i++) {
                int tmp = Math.min(idx + k, n - m + i);
                reverse(arr, idx, tmp);
                idx = tmp;
            }
            for (int i = 0; i < n; i++) bw.write(arr[i] + " ");
            bw.write("\n");
        } else bw.write(-1 + "\n");
        bw.close();
    }

    static void reverse(int[] v, int start, int end) {
        int tmp;

        for (int i = start; i < (start + end) / 2; i++) {
            tmp = v[i];
            v[i] = v[end - i - 1];
            v[end - i - 1] = tmp;
        }
    }
}





