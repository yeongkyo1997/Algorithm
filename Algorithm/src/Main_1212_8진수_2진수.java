import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1212_8진수_2진수 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int s = 0;

    public static void main(String[] args) throws Exception {
        String input = br.readLine();
        int len = input.length();

        if (input.charAt(0) != '0') {
            for (int i = 0; i < len; i++) binary(input.charAt(i) - 48, i);
        } else bw.write("0");
        bw.close();
    }

    static void binary(int n, int i) throws Exception {
        if (i == 0 && n <= 3) {
            s = 1;
            if (n == 1) s = 0;
        } else s = 2;

        for (int j = s; j >= 0; j--) {
            if (n >= Math.pow(2, j)) {
                bw.write("1");
                n -= (int) Math.pow(2, j);
            } else bw.write("0");
        }
    }
}