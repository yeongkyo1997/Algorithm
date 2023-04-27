import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2903_중앙_이동_알고리즘 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int n = 2;
        int a = 1;

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            n += a;
            a *= 2;
        }

        bw.write((int) Math.pow(n, 2) + "\n");
        bw.close();
    }
}
