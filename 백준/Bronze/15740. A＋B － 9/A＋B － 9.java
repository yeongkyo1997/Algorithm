import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        BigInteger A = new BigInteger(String.valueOf(Integer.parseInt(st.nextToken())));
        BigInteger B = new BigInteger(String.valueOf(Integer.parseInt(st.nextToken())));
        bw.write(A.add(B) + "\n");
        bw.close();
    }
}