import java.io.*;
import java.util.StringTokenizer;

public class Main_11003_최솟값_찾기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, L;
    static int[] arr;
    static int[] min;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        arr = new int[N];
        min = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right = 0;
        while (right < N) {
            if (right - left + 1 > L) {
                left++;
            }
            if (right - left + 1 == L) {
                int min = Integer.MAX_VALUE;
                for (int i = left; i <= right; i++) {
                    min = Math.min(min, arr[i]);
                }
                bw.write(min + " ");
                left++;
            }
            right++;
        }
        bw.close();
    }
}
