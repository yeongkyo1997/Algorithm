import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main_2338_긴자리_계산 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BigInteger A = new BigInteger(br.readLine());
        BigInteger B = new BigInteger(br.readLine());

        bw.write(A.add(B) + "\n");
        bw.write(A.subtract(B) + "\n");
        bw.write(A.multiply(B) + "\n");

        bw.close();
    }
}
