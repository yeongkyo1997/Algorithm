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
        st = new StringTokenizer(br.readLine());
        String num = st.nextToken();
        int N = Integer.parseInt(st.nextToken());

        int sum = 0;

        for (int i = 0; i < num.length(); i++) {
            int tmp = num.charAt(num.length() - (i + 1));

            tmp = '0' <= tmp && tmp <= '9' ? tmp - '0' : tmp + 10 - 'A';
            sum += (tmp * (int) Math.pow(N, i));
        }
        bw.write(sum + "\n");
        bw.close();
    }
}