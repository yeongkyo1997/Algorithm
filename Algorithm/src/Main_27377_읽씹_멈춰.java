import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main_27377_읽씹_멈춰 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            BigInteger n = new BigInteger(br.readLine());
            st = new StringTokenizer(br.readLine());
            BigInteger s = new BigInteger(st.nextToken());
            BigInteger t = new BigInteger(st.nextToken());
            BigInteger result = BigInteger.ZERO;

            while (n.compareTo(BigInteger.ZERO) > 0) {
                if (n.mod(BigInteger.valueOf(2)).compareTo(BigInteger.ONE) == 0) {
                    n = n.subtract(BigInteger.ONE);
                    result = result.add(s);
                } else {
                    n = n.divide(BigInteger.valueOf(2));
                    result = n.multiply(s).compareTo(t) < 0 ? result.add(n.multiply(s)) : result.add(t);
                }
            }
            bw.write(result + "\n");
        }
        bw.close();
    }
}