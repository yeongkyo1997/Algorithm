import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StreamTokenizer st;

    static int hansu(int n) {
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (isHansu(i)) {
                cnt++;
            }
        }
        return cnt;
    }

    static boolean isHansu(int num) {
        String str = Integer.toString(num);
        if (str.length() < 2) {
            return true;
        }
        int diff = str.charAt(1) - str.charAt(0);
        for (int i = 2; i < str.length(); i++) {
            if (str.charAt(i) - str.charAt(i - 1) != diff) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        bw.write(hansu(n) + "");
        bw.flush();
        bw.close();
    }
}