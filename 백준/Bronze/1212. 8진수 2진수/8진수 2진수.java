import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static String N;
    static String[] bin = { "000", "001", "010", "011", "100", "101", "110", "111" };

    public static void main(String[] args) throws Exception {
        N = br.readLine();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N.length(); i++) {
            sb.append(bin[N.charAt(i) - '0']);
        }
        if (N.equals("0"))
            bw.write('0');
        else {
            while (sb.charAt(0) == '0') {
                sb = new StringBuilder(sb.substring(1));
            }
            bw.write(sb.toString());
        }
        bw.close();
    }
}