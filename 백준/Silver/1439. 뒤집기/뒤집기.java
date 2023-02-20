import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        String str = br.readLine();

        int zero = 0;
        int one = 0;

        int start = 0;
        int end = 0;

        while (true) {
            while (end < str.length() && str.charAt(start) == str.charAt(end)) end++;
            if (str.charAt(start) == '0') zero++;
            else one++;
            start = end;
            if (end == str.length()) break;
        }
        bw.write(Math.min(zero, one) + "");
        bw.close();
    }
}