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
        int[] cost;
        st = new StringTokenizer(br.readLine());
        cost = IntStream.range(0, n).map(i -> Integer.parseInt(st.nextToken())).toArray();

        int Y = 0, M = 0;
        for (int i = 0; i < n; i++) {
            Y += cost[i] / 30 + 1;
            M += cost[i] / 60 + 1;
        }

        Y *= 10;
        M *= 15;
        bw.write(Y == M ? "Y M " + Y : Y > M ? "M " + M : "Y " + Y);
        bw.close();
    }
}