import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Main_2566 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int x = -1, y = -1;
        int max = -1;

        for (int i = 1; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < 10; j++) {
                int num = parseInt(st.nextToken());

                if (max < num) {
                    max = num;
                    x = i;
                    y = j;
                }
            }
        }
        bw.write(max + "\n" + x + " " + y);
        bw.flush();
        bw.close();
    }
}
