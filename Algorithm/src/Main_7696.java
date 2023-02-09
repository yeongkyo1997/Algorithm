import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_7696 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static boolean[] visited = new boolean[10];
    static int cnt;
    static int[] inputs = new int[9];
    static int[] numbers = new int[9];
    private static int num;

    public static void main(String[] args) throws IOException {
        while (true) {
            num = Integer.parseInt(br.readLine());
            if (num == 0)
                break;
            cnt = 0;

            for (int i = 1; i < 8; i++) {
                combi(i, 0);
            }
        }
        bw.flush();
        bw.close();
    }

    static void combi(int n, int depth) throws IOException {
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
            if (visited[i])
                continue;
            visited[i] = true;
            numbers[depth] = inputs[i];
            combi(n, depth + 1);
            visited[i] = false;
        }
    }
}
