import java.io.*;
import java.util.StringTokenizer;

import static java.util.stream.IntStream.range;

public class Main_6603 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] numbers = new int[6];
    static int k;
    static int[] inputs;

    public static void main(String[] args) throws IOException {
        while (true) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if (k == 0) break;

            inputs = new int[k];
            range(0, k).forEach(i -> inputs[i] = Integer.parseInt(st.nextToken()));
            dfs(0, 0);
            bw.write("\n" + "");
        }
        bw.close();
    }

    static void dfs(int depth, int start) throws IOException {
        if (depth == 6) {
            for (int i = 0; i < 6; i++) {
                bw.write(numbers[i] + " ");
            }
            bw.write("\n" + "");
            return;
        }

        for (int i = start; i < k; i++) {
            numbers[depth] = inputs[i];
            dfs(depth + 1, i + 1);
        }
    }
}
