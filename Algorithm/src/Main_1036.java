import java.io.*;
import java.util.StringTokenizer;

// BOJ 1036번: 36 진수
public class Main_1036 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        System.out.println(Integer.parseInt("GOOD", 36));
    }

    static String tenTo36(int num) {
        StringBuilder sb = new StringBuilder();
        if (num == 0) return "0";

        while (num > 0) {
            if (num % 36 < 10) sb.append(num % 36);
            else sb.append((char) (num % 36 - 10 + 'A'));

            num /= 36;
        }

        return sb.reverse().toString();
    }
}
