import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_15989 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        while (T-- != 0) {
            int num = Integer.parseInt(br.readLine());
            result = 0;

            solution(1, num);

            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
    }

    static void solution(int start, int num) {
        if (num <= 0) {
            if (num == 0)
                result++;
            return;
        }

        for (int i = start; i <= 3; i++) {
            solution(i, num - i);
        }
    }
}
