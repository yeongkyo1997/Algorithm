import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_3079_입국심사 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N, M;
    static long[] arr;

    static long sol(long[] arr, int M) {
        long left = 1, right = (long) arr[0] * M;
        long ans = 0;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long sum = 0;
            for (long j : arr) sum += (mid / j);


            if (sum < M) left = mid + 1;
            else {
                ans = mid;
                right = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new long[N];

        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());

        bw.write(sol(arr, M) + "");
        bw.close();
    }
}