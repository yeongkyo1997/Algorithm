import java.io.*;
import java.util.StringTokenizer;

public class Main_5525_IOIOI {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N, M;
    static String str;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        str = br.readLine();

        for (int i = 0; i < M; i++) {
            int k = 0;
            if (str.charAt(i) != 'O') {
                while (i + 1 < M && i + 2 < M && str.charAt(i + 1) == 'O' && str.charAt(i + 2) == 'I') {
                    k++;
                    if (k == N) {
                        k--;
                        result++;
                    }
                    i += 2;
                }
            }
        }
        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }
}