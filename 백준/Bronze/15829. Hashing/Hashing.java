import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static final int MOD = 1234567891;
    static final int MOD2 = 31;

    public static void main(String[] args) throws IOException {
        int L = Integer.parseInt(br.readLine());
        String s = br.readLine();

        long sum = 0;
        long R = 1;

        for (int i = 0; i < s.length(); i++) {
            sum = (sum + (s.charAt(i) - 'a' + 1) * R) % MOD;
            R = (R * MOD2) % MOD;
        }
        bw.write(sum + "\n");
        bw.flush();
        bw.close();
    }
}
