import java.io.*;
import java.util.StringTokenizer;

public class Main_16637 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int[] num;
    static char[] op;
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        num = new int[N / 2 + 1];
        op = new char[N / 2];

        String str = br.readLine();

        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) num[i / 2] = str.charAt(i) - '0';
            else op[i / 2] = str.charAt(i);
        }


        bw.write(result + "\n");
        bw.close();
    }

    static void dfs(int idx, int sum) {
        if (idx >= N / 2) {
            result = Math.max(result, sum);
            return;
        }

        dfs(idx + 1, sum + num[idx + 1]);
        dfs(idx + 2, sum + calc(num[idx], num[idx + 1], op[idx]));
    }

    static int calc(int a, int b, char op) {
        if (op == '+') return a + b;
        else if (op == '-') return a - b;
        else return a * b;
    }
}
