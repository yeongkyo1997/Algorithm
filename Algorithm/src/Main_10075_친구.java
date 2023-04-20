import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main_10075_친구 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int n;
    static int[] trust, host, protocol;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        trust = new int[100005];
        host = new int[100005];
        protocol = new int[100005];

        st = new StringTokenizer(br.readLine());
        IntStream.range(0, n).forEach(i -> trust[i] = Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n - 1; i++) {
            host[i] = Integer.parseInt(st.nextToken());
            protocol[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        for (int i = n - 1; i >= 1; i--) {
            if (protocol[i] == 0) {
                result += trust[i];
                trust[host[i]] = Math.max(0, trust[host[i]] - trust[i]);
            }

            if (protocol[i] == 1) trust[host[i]] += trust[i];
            if (protocol[i] == 2) trust[host[i]] = Math.max(trust[host[i]], trust[i]);
        }

        bw.write(String.valueOf(trust[0] + result));
        bw.close();
    }
}