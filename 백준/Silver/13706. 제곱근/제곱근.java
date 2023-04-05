import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BigInteger n = new BigInteger(br.readLine());
        BigInteger left = BigInteger.ONE;
        BigInteger right = new BigInteger(String.valueOf(n));
        int result;

        while (true) {
            BigInteger mid = left.add(right).divide(new BigInteger("2"));
            result = (mid.multiply(mid)).compareTo(n);

            if (result == 0) {
                bw.write(String.valueOf(mid));
                break;
            } else if (result == 1) {
                right = mid.subtract(new BigInteger("1"));
            } else {
                left = mid.add(new BigInteger("1"));
            }
        }
        bw.close();
    }
}