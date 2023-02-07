import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_7696 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static boolean[] visited2 = new boolean[1000001];

    public static void main(String[] args) throws IOException {
        int n;
        int cnt, cur;
        while (true) {
            n = Integer.parseInt(br.readLine());
            if (n == 0)
                break;
            cnt = 0;
            cur = 0;

            while (n > cnt) {
                if (solve(++cur))
                    cnt++;
            }
            bw.write(cur + "\n");
        }
        bw.flush();
        bw.close();
    }

    static boolean solve(int n) {
        int cur = n;
        if (n % 10 == 0)
            return true;
        boolean[] visited = new boolean[n + 1];

        for (int i = 1000000; i >= 10; i /= 10) {
            if (visited2[cur % i]) {
                if (cur < 1000000) {
                    visited2[cur] = true;
                    return false;
                }
            }
        }

        while (n != 0) {
            if (visited[n % 10]) {
                if (cur < 1000000) {
                    visited2[cur] = true;
                }
                return false;
            }
            visited[n % 10] = true;
            n /= 10;
        }
        return true;
    }
}