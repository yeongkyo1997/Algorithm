import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] buildings = IntStream.range(0, n).map(i -> Integer.parseInt(st.nextToken())).toArray();

        int[] cnt = new int[n];
        for (int i = 0; i < n; i++) {
            double maxGradient = -1000000000;

            for (int j = i + 1; j < n; j++) {
                int h = buildings[j] - buildings[i];
                int w = j - i;
                double g = h * 1.0 / w;

                if (g <= maxGradient) continue;

                maxGradient = g;
                cnt[i]++;
                cnt[j]++;
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) max = Math.max(max, cnt[i]);

        bw.write(String.valueOf(max));
        bw.close();
    }

}