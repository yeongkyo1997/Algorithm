import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main_2609 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        BigInteger a = new BigInteger(st.nextToken());
        BigInteger b = new BigInteger(st.nextToken());

        bw.write(a.gcd(b) + "\n");
        bw.write((a.multiply(b).divide(a.gcd(b))) + "");
        bw.close();
    }
}
