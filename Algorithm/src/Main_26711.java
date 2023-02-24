import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main_26711 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BigInteger a = new BigInteger(br.readLine());
        BigInteger b = new BigInteger(br.readLine());
        bw.write(a.add(b) + "");
        bw.close();
    }
}
