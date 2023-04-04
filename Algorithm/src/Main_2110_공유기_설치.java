import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2110_공유기_설치 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int left = 1;
        int right = arr[N - 1] - arr[0];
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            int start = arr[0];
            int cnt = 1;

            for (int i = 1; i < N; i++) {
                if (arr[i] - start >= mid) {
                    cnt++;
                    start = arr[i];
                }
            }

            if (cnt >= C) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        bw.write(result + "");
        bw.close();
    }
}
