import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2851_슈퍼_마리오 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int[] m = new int[10];
        int score = 0;

        for (int i = 0; i < 10; i++) {
            m[i] = Integer.parseInt(br.readLine());
            score += m[i];

            if (score >= 100) {
                if (score - 100 > 100 - (score - m[i])) {
                    score -= m[i];
                }
                break;
            }
        }

        bw.write(String.valueOf(score));
        bw.close();
    }
}