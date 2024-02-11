import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] argrs) throws Exception {
        BigInteger A = new BigInteger(br.readLine());
        BigInteger B = new BigInteger(br.readLine());

        bw.write(String.valueOf(A.add(B)) + "\n");
        bw.write(String.valueOf(A.subtract(B)) + "\n");
        bw.write(String.valueOf(A.multiply(B)) + "\n");
        bw.close();
    }
}