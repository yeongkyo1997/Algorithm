import java.io.*;
import java.util.StringTokenizer;

public class Main_1806_부분합 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int left = 0;
        int right = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        while (true) {
            if (sum >= S) {
                minLength = Math.min(minLength, right - left);
                sum -= arr[left];
                left++;
            } else if (right == N) break;
            else {
                sum += arr[right];
                right++;
            }
        }
        if (minLength == Integer.MAX_VALUE) bw.write("0");
        else bw.write(String.valueOf(minLength));
        bw.close();
    }
}