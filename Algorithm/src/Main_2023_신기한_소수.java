import java.io.*;
import java.util.StringTokenizer;

public class Main_2023_신기한_소수 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int[] prime = {1, 2, 3, 5, 7, 9};

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        dfs(0, 0);
        bw.flush();
        bw.close();
    }

    static boolean isPrime(int n) {
        if (n < 2)
            return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    static void dfs(int cur, int depth) throws IOException {
        if (depth == N) {
            bw.write(cur + "\n");
            return;
        }

        for (int j : prime) {
            int num = cur * 10 + j;
            if (isPrime(num))
                dfs(num, depth + 1);
        }
    }
}