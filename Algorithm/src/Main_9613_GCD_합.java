import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main_9613_GCD_합 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    private static int[] list;
    private static int n;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            list = new int[n];
            IntStream.range(0, n).forEach(i -> list[i] = Integer.parseInt(st.nextToken()));

            long result = 0;
            for (int i = 0; i < n; i++) for (int j = i + 1; j < n; j++) result += gcd(list[i], list[j]);
            bw.write(result + "\n");
        }
        bw.close();
    }


    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}