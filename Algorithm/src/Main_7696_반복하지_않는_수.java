import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_7696_반복하지_않는_수 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static boolean[] visited = new boolean[10];
    static int cnt;
    static int[] used = new int[10];
    static int[] numbers = new int[10];
    private static int num;

    public static void main(String[] args) throws IOException {
        while (true) {
            num = Integer.parseInt(br.readLine());
            if (num == 0) break;
            cnt = 0;

            for (int i = 1; i < 8; i++) {
                perm(i, 0);
            }
        }
        bw.flush();
        bw.close();
    }

    static void perm(int n, int depth) throws IOException {
        if (depth == n) {
            cnt++;

            if (cnt == num) {
                for (int i = 0; i < depth; i++) {
                    bw.write(numbers[i] + "");
                }
                bw.write("\n");
            }
            return;
        }

        for (int i = 1; i < 10; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            numbers[depth] = i;
            perm(n, depth + 1);
            visited[i] = false;
        }
    }
}
