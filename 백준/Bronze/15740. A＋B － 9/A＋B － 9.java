import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BigInteger a, b;
        st = new StringTokenizer(br.readLine());
        a = new BigInteger(st.nextToken());
        b = new BigInteger(st.nextToken());
        bw.write(a.add(b) + "");

        bw.close();
    }
}