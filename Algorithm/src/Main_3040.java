import java.io.*;
import java.util.StringTokenizer;

public class Main_3040 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] inputs = new int[9];
    static int[] result = new int[2];


    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 9; i++) inputs[i] = Integer.parseInt(br.readLine());
        comb(0, 0, 0);
    }

    static void comb(int cnt, int start, int flag) throws IOException {
        if (cnt == 7) {
            int sum = 0;
            for (int i = 0; i < 9; i++) {
                if ((flag & 1 << i) != 0) {
                    sum += inputs[i];
                }
            }
            if (sum == 100) {
                for (int i = 0; i < 9; i++) {
                    if ((flag & 1 << i) != 0) {
                        bw.write(inputs[i] + "\n");
                    }
                }
                bw.close();
            }
            return;
        }

        for (int i = start; i < 9; i++) comb(cnt + 1, i + 1, flag | 1 << i);
    }
}
