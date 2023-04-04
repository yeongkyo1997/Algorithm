import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1153_네_개의_소수 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static boolean[] primeList = new boolean[1000001];
    static int[] result = new int[4];
    static int N;

    static public void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        primeList[0] = true;
        primeList[1] = true;
        for (int i = 2; i < primeList.length; i++) {
            if (primeList[i])
                continue;
            for (int j = i + i; j < primeList.length; j += i) {
                primeList[j] = true;
            }
        }

        boolean flag = dfs(0, 0);
        if (!flag)
            bw.write("-1");
        else
            for (int i = 0; i < 4; i++) {
                bw.write(result[i] + " ");
            }
        bw.flush();
    }

    static boolean dfs(int depth, int sum) throws IOException {
        if (depth == 4) {
            if (sum == N) {
                for (int i = 0; i < 4; i++) {
                    Arrays.sort(result);
                }
                return true;
            }
            return false;
        }
        for (int i = N - sum; i >= 2; i--) {
            if (primeList[i])
                continue;
            result[depth] = i;
            if (dfs(depth + 1, sum + i))
                return true;
        }
        return false;
    }
}
