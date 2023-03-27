import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, ans;
    static long M;
    static int[] data;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        data = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(data);
        tree(0, data[N - 1]);
        bw.write(ans + "");
        bw.flush();
        bw.close();

    }

    private static void tree(int start, int end) {
        int mid;
        while (start <= end) {
            long sum = 0;
            mid = (start + end) / 2;

            for (int i = 0; i < N; i++) {
                if (data[i] > mid) sum += data[i] - mid;
            }
            if (sum == M) {
                ans = mid;
                break;
            } else if (sum > M) {
                ans = Math.max(ans, mid);
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
    }
}