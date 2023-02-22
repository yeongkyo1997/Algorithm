import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        long result = 0L;
        int[] list = new int[K];

        for (int i = 0; i < K; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }

        long left = 1L;
        long right = 2147483647L;

        while (left <= right) {
            long mid = (left + right) / 2;
            long cnt = 0L;
            for (int i = 0; i < K; i++) {
                cnt += list[i] / mid;
            }
            if (cnt >= N) {
                result = Math.max(result, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        bw.write(result + "");
        bw.close();
    }
}