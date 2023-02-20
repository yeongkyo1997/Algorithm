import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int a, b;
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        int cnt = 0;
        int result = 0;

        for (int i = 1; i <= a; i++) {
            if (a % i == 0) {
                cnt++;
                if (cnt == b) {
                    result = i;
                    break;
                }
            }
        }
        bw.write(result + "");
        bw.flush();
        bw.close();
    }
}
