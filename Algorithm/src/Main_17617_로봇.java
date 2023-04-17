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

    static int n, m, r;
    static int[] robot;
    static int[] rdif;

    static int sum, mxsum;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        robot = new int[n + 1];
        rdif = new int[2 * n];
        st = new StringTokenizer(br.readLine());

        IntStream.range(0, n).forEach(i -> robot[i] = Integer.parseInt(st.nextToken()));

        sort(robot, 0, n - 1);
        robot[n] = robot[0] + m;

        IntStream.range(0, n).forEach(i -> rdif[i] = rdif[i + n] = robot[i + 1] - robot[i] - r * 2);

        for (int i = 0; i < 2 * n - 1; i++) {
            sum += rdif[i];
            if (sum < 0) sum = 0;
            mxsum = Math.max(mxsum, sum);
        }
        bw.write((mxsum + 1) / 2 + "\n");
        bw.close();
    }
}
