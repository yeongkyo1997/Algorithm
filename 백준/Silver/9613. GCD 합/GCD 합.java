import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    private static int[] list;
    private static int n;
    static int[] tmp = new int[2];

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            list = new int[n];
            for (int i = 0; i < n; i++) {
                list[i] = Integer.parseInt(st.nextToken());
            }

            long result = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    result += gcd(list[i], list[j]);
                }
            }
            bw.write(result + "\n");
        }
        bw.close();
    }


    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}