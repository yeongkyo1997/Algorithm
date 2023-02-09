import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_3040 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] inputs = new int[9];
    static int[] result = new int[7];

    public static void main(String[] args) throws IOException {
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            inputs[i] = Integer.parseInt(br.readLine());
            sum += inputs[i];
        }
        int a = 0, b = 0;

        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                sum -= inputs[i] + inputs[j];
                if (sum == 100) {
                    a = i;
                    b = j;
                }
                sum += inputs[i] + inputs[j];
            }
        }

        for (int i = 0; i < 9; i++) {
            if (i == a || i == b)
                continue;
            bw.write(inputs[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    static void solve(int depth, int sum, int start) throws IOException {
        if (depth == 7) {
            if (sum == 100) {
                for (int i = 0; i < 7; i++) {
                    bw.write(result[i] + "\n");
                }
            }
            return;
        }
        for (int i = start; i < 9; i++) {
            result[depth] = inputs[i];
            solve(depth + 1, sum + inputs[i], i + 1);
        }
    }
}