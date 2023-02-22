import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int input[];
    static int numbers[];
    static int N, M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        input = new int[N];
        numbers = new int[M];
        for (int i = 0; i < N; i++) {
            input[i] = i + 1;
        }
        perm(0, 0);
        bw.close();
    }

    static void perm(int cnt, int flag) throws IOException {
        if (cnt == M) {
            for (int number : numbers) {
                bw.write(number + " ");
            }
            bw.write("\n" + "");
            return;
        }

        for (int i = 0; i < N; i++) {
            if ((flag & 1 << i) != 0) continue;

            numbers[cnt] = input[i];
            perm(cnt + 1, (flag | 1 << i));
        }
    }
}