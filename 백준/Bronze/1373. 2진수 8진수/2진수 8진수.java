import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        StringBuilder str = new StringBuilder(br.readLine());
        while (str.length() % 3 != 0) str.insert(0, '0');

        for (int i = 0; i < str.length(); i += 3) {
            int num = (str.charAt(i) - '0') * 4 + (str.charAt(i + 1) - '0') * 2 + (str.charAt(i + 2) - '0');
            bw.write(String.valueOf(num));
        }
        bw.close();
    }
}