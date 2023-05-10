import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        int cnt = 0;
        int sum = 0;
        int left = 1;
        int right = 1;

        while (left <= N) {
            if (sum < N) {
                sum += right++;
            } else if (sum > N) {
                sum -= left++;
            } else {
                cnt++;
                sum += right++;
            }
        }

        bw.write(String.valueOf(cnt));

        bw.close();
    }
}