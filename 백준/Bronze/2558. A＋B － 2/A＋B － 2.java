import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int a, b;
        a = Integer.parseInt(br.readLine());
        b = Integer.parseInt(br.readLine());

        bw.write(String.valueOf(a + b));
        bw.close();
    }
}