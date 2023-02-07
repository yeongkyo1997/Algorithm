import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1094 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    private static int n;
    static int result = 0;
    static int[] visited = new int[65];

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        binary(0, 64, 0);

    }

    static void binary(int sum, int stick, int depth) throws IOException {
        if (visited[stick] != 0)
            return;
        if (stick == 0)
            return;
        if (sum == n) {
            result = depth;
            bw.write(depth + "\n");
            bw.flush();
            bw.close();
            System.exit(0);
        }

        if (stick <= n) {
            visited[stick] = depth + 1;
            binary(sum + stick / 2, stick / 2, depth + 1);
            binary(sum + (int) Math.ceil(stick / 2), stick / 2, depth + 1);
        }
    }
}
