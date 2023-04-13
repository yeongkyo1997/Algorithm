import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N, M;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        int left = -1;
        int right = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            left = Math.max(arr[i], left);
            right += arr[i];
        }

        while (left <= right) {
            int mid = (left + right) / 2;
            int tmp = 0, cnt = 0;

            for (int i = 0; i < N; i++) {
                if (tmp + arr[i] > mid) {
                    tmp = 0;
                    cnt++;
                }
                tmp += arr[i];
            }
            if (tmp != 0) cnt++;

            if (cnt <= M) right = mid - 1;
            else left = mid + 1;

        }
        bw.write(String.valueOf(left));
        bw.close();
    }
}