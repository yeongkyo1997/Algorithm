import java.io.*;
import java.util.StringTokenizer;

public class Main_1977 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int sum = 0;
        int min = 0;

        for (int i = N; i <= M; i++) {
            if (isSquare(i)) {
                sum += i;
                if (min == 0) min = i;
            }
        }
        if (sum == 0) bw.write("-1");
        else bw.write(sum + "\n" + min);
        bw.close();
    }

    static boolean isSquare(int n) {
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }
}
