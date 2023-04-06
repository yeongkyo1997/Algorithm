import java.io.*;
import java.util.StringTokenizer;

public class Main_27931_Parity_Constraint_Closest_Pair {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int INF = 1000000001;
    static int a = INF;
    static int b = INF;
    private static int[] arr;
    private static int n;
    private static int[] numbers;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        numbers = new int[2];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        combi(0, 0);

        if (a == INF) a = -1;
        if (b == INF) b = -1;

        bw.write(a + " " + b);
        bw.close();
    }

    static void combi(int start, int depth) {
        if (depth == 2) {
            int dist = Math.abs(numbers[0] - numbers[1]);

            if (dist % 2 == 0) a = Math.min(dist, a);
            else b = Math.min(dist, b);
            return;
        }

        for (int i = start; i < n; i++) {
            numbers[depth] = arr[i];
            combi(i + 1, depth + 1);
        }
    }
}
