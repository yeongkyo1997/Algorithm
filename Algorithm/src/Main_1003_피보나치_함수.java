import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main_1003_피보나치_함수 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;


    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        int[] mem = new int[41];
        mem[0] = 0;
        mem[1] = 1;
        mem[2] = 1;

        IntStream.range(3, 41).forEach(i -> mem[i] = mem[i - 1] + mem[i - 2]);

        int t = 0;
        while (t < T) {
            int N = Integer.parseInt(br.readLine());
            bw.write(N == 0 ? "1 0\n" : mem[N - 1] + " " + mem[N] + "\n");
            t++;
        }
        bw.close();
    }
}