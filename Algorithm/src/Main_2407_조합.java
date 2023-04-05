import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2407_조합 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int n, m;
    static String[][] factorial = new String[101][101];

    static String bigNumAdd(String n1, String n2) {
        int sum = 0;
        StringBuilder result = new StringBuilder();

        while (!n1.isEmpty() || !n2.isEmpty() || sum != 0) {
            if (!n1.isEmpty()) {
                sum += n1.charAt(n1.length() - 1) - '0';
                n1 = n1.substring(0, n1.length() - 1);
            }
            if (!n2.isEmpty()) {
                sum += n2.charAt(n2.length() - 1) - '0';
                n2 = n2.substring(0, n2.length() - 1);
            }
            result.insert(0, (sum % 10));
            sum /= 10;
        }
        return result.toString();
    }

    static String combination(int n, int r) {
        if (n == r || r == 0) {
            return "1";
        }
        String result = factorial[n][r];

        if (result != null) {
            return result;
        }

        result = bigNumAdd(combination(n - 1, r - 1), combination(n - 1, r));
        return result;
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        bw.write(combination(n, m));
        bw.flush();
        bw.close();
    }
}