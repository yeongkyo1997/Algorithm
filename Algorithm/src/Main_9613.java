import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_9613 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static List<Integer> numbers = new ArrayList();
    private static int[] list;
    private static int n;
    static int[] tmp = new int[2];

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            numbers.clear();
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            list = new int[n];
            for (int i = 0; i < n; i++) {
                list[i] = Integer.parseInt(st.nextToken());
            }
            combi(0, 0);
            int result = numbers.stream().mapToInt(x -> x).sum();
            bw.write(result + "\n");
        }
        bw.close();
    }

    static void combi(int depth, int start) {
        if (depth == 2) {
            numbers.add(gcd(tmp[0], tmp[1]));
            return;
        }

        for (int i = start; i < n; i++) {
            tmp[depth] = list[i];
            combi(depth + 1, i + 1);
        }
    }

    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
