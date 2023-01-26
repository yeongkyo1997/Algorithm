import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1676 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        if (N < 5) {
            bw.write(0 + "\n");
        } else {
            int two = 0;
            int five = 0;

            for (int i = 1; i < N + 1; i++) {
                two += countTwo(i);
                five += countFive(i);
            }
            bw.write(Math.min(five, two) + "\n");
        }
        bw.flush();
        bw.close();
    }

    static int countTwo(int n) {
        int result = 0;
        while (n % 2 == 0) {
            result++;
            n /= 2;
        }
        return result;
    }

    static int countFive(int n) {
        int result = 0;
        while (n % 5 == 0) {
            result++;
            n /= 5;
        }
        return result;
    }
}
