import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static boolean[] is = new boolean[1000001];

    public static void main(String[] args) throws IOException {
        long min, max;
        st = new StringTokenizer(br.readLine());
        min = Long.parseLong(st.nextToken());
        max = Long.parseLong(st.nextToken());

        for (long i = 2; i * i <= max; i++) {
            long start = min / (i * i);
            if (start * i * i != min)
                start++;
            for (Long j = start; i * i * j <= max; j++) {
                is[(int) (i * i * j - min)] = true;
            }
        }
        int cnt = 0;
        for (int i = 0; i < max - min + 1; i++) {
            if (!is[i])
                cnt++;
        }
        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
    }
}
