import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main_27433 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        BigInteger result = BigInteger.ONE;

        for (int i = 1; i < N + 1; i++) {
            result = result.multiply(new BigInteger(String.valueOf(i)));
        }
        bw.write(result + "");
        bw.close();
    }
}
