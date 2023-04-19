import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

import static java.util.Arrays.sort;

public class Main_17617_로봇 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N;
    static long M;
    static long R;
    static long[] robot;
    static long[] check;

    static long sum;
    static long max;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        R = Long.parseLong(st.nextToken());
        M = Long.parseLong(st.nextToken());
        robot = new long[N + 1];
        check = new long[2 * N];

        st = new StringTokenizer(br.readLine());
        IntStream.range(0, N).forEach(i -> robot[i] = Integer.parseInt(st.nextToken()));

        sort(robot, 0, N - 1);
        robot[N] = robot[0] + M;

        IntStream.range(0, N).forEach(i -> check[i] = check[i + N] = robot[i + 1] - robot[i] - R * 2);

        for (int i = 0; i < 2 * N - 1; i++) {
            sum += check[i];

            if (sum < 0) sum = 0;
            max = Math.max(max, sum);
        }

        bw.write((max + 1) / 2 + "\n");
        bw.close();
    }
}