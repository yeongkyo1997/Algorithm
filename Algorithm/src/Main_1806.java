import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1806 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] list = new int[N];
        int left = 0;
        int right = 0;
        int sum = list[0];
        int result = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        while (right < N) {
            if (sum >= S) {
                result = Math.min(right - left, result);
                sum -= list[left++];
            } else {
                sum += list[right++];
            }
        }

        if (result == Integer.MAX_VALUE)
            bw.write(0 + "\n");
        else
            bw.write(result + "\n");
        bw.flush();
        bw.close();
    }
}
