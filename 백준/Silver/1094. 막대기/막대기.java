import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int X = Integer.parseInt(br.readLine());

        int[] arr = new int[64];
        int idx = 0;
        while (X > 0) {
            arr[idx++] = X % 2;
            X /= 2;
        }

        int cnt = 0;
        for (int i = 0; i < idx; i++) {
            if (arr[i] == 1) {
                cnt++;
            }
        }

        bw.write(cnt + "\n");
        bw.close();
    }
}